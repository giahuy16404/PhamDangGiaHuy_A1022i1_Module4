package com.example.furama.service.customer.itf;

import com.example.furama.model.customer.Customer;
import com.example.furama.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findPage(Pageable pageable);

    List<CustomerType> findCustomerType();
    List<Customer> getList();
    Customer add(Customer customer);
    boolean remove(Long id);
    Customer update(Customer customer);
    Page<Customer> findByName(Pageable pageable,String name);
    List<Customer> getCustomer();
    Customer findById(Long id);
}
