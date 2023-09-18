package com.example.furama.rest_controller.customer;

import com.example.furama.dto.customerDto.CustomerDto;
import com.example.furama.model.customer.Customer;
import com.example.furama.model.customer.CustomerType;
import com.example.furama.service.customer.itf.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("api/customer")
public class RestCustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("/getPage")
    public ResponseEntity<Page<Customer>> getPage(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "0") int size,
                                                  @RequestParam(defaultValue = "") String valueSearch
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Customer> getAll = iCustomerService.findPage(pageable);
        if (getAll.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(getAll, HttpStatus.OK);
    }

    @GetMapping("/getList")
    public ResponseEntity<List<Customer>> getList() {
        List<Customer> checkCustomer = iCustomerService.getList();
        if (checkCustomer != null) {
            return new ResponseEntity<>(checkCustomer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    @GetMapping("/getCustomerType")
    public ResponseEntity<List<CustomerType>> getServiceType() {
        List<CustomerType> checkCustomerType = iCustomerService.findCustomerType();
        if (checkCustomerType != null) {
            return new ResponseEntity<>(checkCustomerType, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> add(@RequestBody CustomerDto customerDto,
                                                   BindingResult bindingResult) {
        new CustomerDto().validate(customerDto, bindingResult);
        Map<String, Object> errorInput = new HashMap<>();

        //Check validate
        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorInput.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errorInput, HttpStatus.BAD_REQUEST);
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);

        iCustomerService.add(customer);
        errorInput.put("message", "successful");

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Customer> getServiceType(@PathVariable Long id) {
        Customer checkCustomer = iCustomerService.findById(id);
        if (checkCustomer != null) {
            return new ResponseEntity<>(checkCustomer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<Customer> update(@RequestBody Customer customer) {

        Customer checkCustomer = iCustomerService.update(customer);
        if (checkCustomer != null) {
            return new ResponseEntity<>(checkCustomer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customer> delete(@PathVariable Long id) {
        boolean check = iCustomerService.remove(id);
        if (check) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FOUND);
    }
}
