package com.example.test_1.repository;

import com.example.test_1.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType,Long> {
}
