package com.example.furama.service.customer;

import com.example.furama.model.customer.Customer;
import com.example.furama.model.customer.CustomerType;
import com.example.furama.repository.customer.ICustomerRepository;
import com.example.furama.repository.customer.ICustomerTypeRepository;
import com.example.furama.service.customer.itf.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public List<CustomerType> findCustomerType() {
        return iCustomerTypeRepository.findAll();
    }

    @Override
    public boolean add(Customer customer) {
        try {
            iCustomerRepository.save(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean remove(Long id) {
        try {
            iCustomerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Customer customer) {
        try {
            iCustomerRepository.save(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Page<Customer> findByName(Pageable pageable, String name) {
        return iCustomerRepository.findByName(pageable,"%" + name + "%");
    }

    @Override
    public List<Customer> getCustomer() {
        return iCustomerRepository.findAll();
    }
}
