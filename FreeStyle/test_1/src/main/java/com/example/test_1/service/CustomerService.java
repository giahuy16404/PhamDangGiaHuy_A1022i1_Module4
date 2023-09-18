package com.example.test_1.service;

import com.example.test_1.model.Customer;
import com.example.test_1.model.CustomerType;
import com.example.test_1.repository.ICustomerRepository;
import com.example.test_1.repository.ICustomerTypeRepository;
import com.example.test_1.util.FormatDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;
    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Override
    public List<CustomerType> findCustomerType() {
        return iCustomerTypeRepository.findAll();
    }

    @Override
    public Customer add(Customer customer) {
        return iCustomerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return iCustomerRepository.save(customer);
    }

    @Override
    public Page<Customer> findPage(Pageable pageable, String valueSearch) {
        Page<Customer> customerPage = iCustomerRepository.findPageAndSearch(pageable,"%"+ valueSearch + "%");
        for (Customer customer: customerPage) {
            customer.setBirthday(FormatDate.formatDate(customer.getBirthday()));
        }
        return customerPage;
    }

    @Override
    public boolean remove(Long id) {
        try {
            iCustomerRepository.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Customer findById(Long id) {
        return iCustomerRepository.findById(id).get();
    }
}
