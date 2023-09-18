package com.example.furama.rest_controller.employee;

import com.example.furama.model.customer.Customer;
import com.example.furama.model.employee.Employee;
import com.example.furama.service.employee.itf.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/employee")
public class RestEmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @GetMapping("/getList")
    public ResponseEntity<List<Employee>> getList() {
        List<Employee> checkEmployee = iEmployeeService.findAll();
        if (checkEmployee != null) {
            return new ResponseEntity<>(checkEmployee, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FOUND);
    }
}
