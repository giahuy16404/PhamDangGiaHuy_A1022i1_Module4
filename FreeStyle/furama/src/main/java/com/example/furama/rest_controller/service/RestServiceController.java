package com.example.furama.rest_controller.service;

import com.example.furama.model.service.RentType;
import com.example.furama.model.service.Service;
import com.example.furama.model.service.ServiceType;
import com.example.furama.service.service.itf.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/service")
public class RestServiceController {
    @Autowired
    private IService iService;

    @GetMapping("/getPage")
    public ResponseEntity<Page<Service>> getPage(@RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "0") int size,
                                                 @RequestParam(defaultValue = "") String valueSearch
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Service> getAll = iService.findPage(pageable);
        if (getAll.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(getAll, HttpStatus.OK);
    }

    @GetMapping("/getList")
    public ResponseEntity<List<Service>> getList() {
        List<Service> checkService = iService.getList();
        if (checkService != null) {
            return new ResponseEntity<>(checkService, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Service service) {

        Service checkService = iService.add(service);
        if (checkService != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    @GetMapping("/getServiceType")
    public ResponseEntity<List<ServiceType>> getServiceType() {
        List<ServiceType> checkServiceType = iService.findServiceType();
        if (checkServiceType != null) {
            return new ResponseEntity<>(checkServiceType, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    @GetMapping("/getRentType")
    public ResponseEntity<List<RentType>> getRentType() {
        List<RentType> checkRentType = iService.findRentType();
        if (checkRentType != null) {
            return new ResponseEntity<>(checkRentType, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FOUND);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable long id) {
        boolean check = iService.delete(id);
        if (check){
            return new ResponseEntity<>( HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/update")
    public ResponseEntity<Service> update(@RequestBody Service service){
        Service checkService = iService.update(service);
        if (checkService != null) {
            return new ResponseEntity<>(checkService,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Service> update(@PathVariable Long id){
        Service checkService = iService.findById(id);
        if (checkService != null) {
            return new ResponseEntity<>(checkService,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FOUND);
    }
}
