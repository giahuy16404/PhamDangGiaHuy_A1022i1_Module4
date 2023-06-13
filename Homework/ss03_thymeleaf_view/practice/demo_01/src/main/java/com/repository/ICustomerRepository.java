package com.repository;

import com.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> showList();
    boolean add(Customer customer);
    boolean remove(int remove);
}
