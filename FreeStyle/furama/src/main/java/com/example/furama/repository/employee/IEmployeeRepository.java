package com.example.furama.repository.employee;

import com.example.furama.QueryDb.QueryEmployeeDb;
import com.example.furama.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = QueryEmployeeDb.FIND_EMPLOYEE_PAGE,nativeQuery = true)
    Page<Employee> findAll(Pageable pageable);

    @Query(value = QueryEmployeeDb.SEARCH_BY_NAME_EMPLOYEE_PAGE,nativeQuery = true)
    Page<Employee> searchByName(Pageable pageable, @Param("name") String name);
}
