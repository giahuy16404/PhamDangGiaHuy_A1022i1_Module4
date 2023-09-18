package com.example.furama.rest_controller.contract;

import com.example.furama.model.contract.Contract;
import com.example.furama.model.customer.Customer;
import com.example.furama.model.employee.Employee;
import com.example.furama.service.contract.itf.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@CrossOrigin("*")
@RestController
@RequestMapping("api/contract")
public class RestContractController {

    @Autowired
    private IContractService iContractService;

    @GetMapping("/getPage")
    public ResponseEntity<Page<Contract>> getPage(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "0") int size,
                                                  @RequestParam(defaultValue = "") String valueSearch
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Contract> getAll = iContractService.findPage(pageable);
        if (getAll.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(getAll, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Contract> add(@RequestBody Contract contract) {
        contract.setStarDate(LocalDate.now().toString());
        Contract checkContract = iContractService.add(contract);
        if (checkContract != null) {
            return new ResponseEntity<>(checkContract,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FOUND);
    }
}
