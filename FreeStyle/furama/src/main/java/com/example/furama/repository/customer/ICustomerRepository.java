package com.example.furama.repository.customer;

import com.example.furama.QueryDb.QueryCustomerDb;
import com.example.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = QueryCustomerDb.FIND_CUSTOMER_PAGE, nativeQuery = true)
    Page<Customer> findAll(Pageable pageable);

    @Query(value = QueryCustomerDb.FIND_BY_NAME, nativeQuery = true)
    Page<Customer> findByName(Pageable pageable, @Param("name") String name);
}
