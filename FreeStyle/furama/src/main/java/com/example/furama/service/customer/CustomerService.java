package com.example.furama.service.customer;

import com.example.furama.model.customer.Customer;
import com.example.furama.model.customer.CustomerType;
import com.example.furama.repository.customer.ICustomerRepository;
import com.example.furama.repository.customer.ICustomerTypeRepository;
import com.example.furama.service.customer.itf.ICustomerService;
import com.example.furama.util.FormatDate;
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
    public Page<Customer> findPage(Pageable pageable) {
        Page<Customer> listCustomer = iCustomerRepository.findAll(pageable);
        for (Customer c:listCustomer) {
            c.setBirthDay(FormatDate.formatDate(c.getBirthDay()));
        }
        return listCustomer;
    }

    @Override
    public List<CustomerType> findCustomerType() {
        return iCustomerTypeRepository.findAll();
    }

    @Override
    public List<Customer> getList() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Customer add(Customer customer) {
        try {
           return iCustomerRepository.save(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean remove(Long id) {
        try {
            iCustomerRepository.deleteCustomer(id);
            iCustomerRepository.deleteContractByCustomer(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Customer update(Customer customer) {
        try {
         return    iCustomerRepository.save(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Page<Customer> findByName(Pageable pageable, String name) {
        return iCustomerRepository.findByName(pageable,"%" + name + "%");
    }

    @Override
    public List<Customer> getCustomer() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return iCustomerRepository.findById(id).get();
    }
}
