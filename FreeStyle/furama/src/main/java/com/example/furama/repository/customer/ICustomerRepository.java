package com.example.furama.repository.customer;

import com.example.furama.QueryDb.QueryCustomerDb;
import com.example.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = QueryCustomerDb.FIND_CUSTOMER_PAGE, nativeQuery = true)
    Page<Customer> findAll(Pageable pageable);

    @Query(value = QueryCustomerDb.FIND_BY_NAME, nativeQuery = true)
    Page<Customer> findByName(Pageable pageable, @Param("name") String name);

    @Query(value = QueryCustomerDb.DELETE_CONTRACT_BY_CUSTOMER,nativeQuery = true)
    @Modifying
    @Transactional
    void deleteContractByCustomer(@Param("id") Long id);
    @Query(value = QueryCustomerDb.DELETE_CUSTOMER,nativeQuery = true)
    @Modifying
    @Transactional
    void deleteCustomer(@Param("id") Long id);
}
