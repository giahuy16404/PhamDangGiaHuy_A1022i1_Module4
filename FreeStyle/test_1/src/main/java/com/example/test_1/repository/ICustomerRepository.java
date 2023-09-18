package com.example.test_1.repository;

import com.example.test_1.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    @Query(value = com.example.test_1.util.Query.FIND_PAGE_AND_SEARCH,nativeQuery = true)
    Page<Customer> findPageAndSearch(Pageable pageable, @Param("valueSearch") String valueSearch);
}
