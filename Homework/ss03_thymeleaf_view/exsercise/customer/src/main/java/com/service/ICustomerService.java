package com.service;

import com.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> showList();
    boolean add(Customer customer);
    boolean remove(int remove);

}
