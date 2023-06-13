package com.service;

import com.model.Customer;
import com.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService {
@Autowired
ICustomerRepository iCustomerRepository;
    @Override
    public List<Customer> showList() {
        return iCustomerRepository.showList();
    }

    @Override
    public boolean add(Customer customer) {
        if (iCustomerRepository.add(customer)){
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(int remove) {
        if (iCustomerRepository.remove(remove)){
            return true;
        }
        return false;
    }
}
