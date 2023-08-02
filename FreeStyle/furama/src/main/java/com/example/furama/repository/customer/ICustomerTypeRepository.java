package com.example.furama.repository.customer;

import com.example.furama.QueryDb.QueryCustomerDb;
import com.example.furama.model.customer.Customer;
import com.example.furama.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType,Long> {



}
