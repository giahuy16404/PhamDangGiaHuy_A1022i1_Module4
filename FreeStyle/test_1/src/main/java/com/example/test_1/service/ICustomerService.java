package com.example.test_1.service;

import com.example.test_1.model.Customer;
import com.example.test_1.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<CustomerType> findCustomerType();
    Customer add(Customer customer);
    Customer update(Customer customer);
    Page<Customer> findPage(Pageable pageable,String valueSearch);
    boolean remove(Long id);
    Customer findById(Long id);
}
