package com.example.furama.repository.employee;

import com.example.furama.QueryDb.EmployeeQueryDb;
import com.example.furama.model.employee.Division;
import com.example.furama.model.employee.EducationDegree;
import com.example.furama.model.employee.Employee;
import com.example.furama.model.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = EmployeeQueryDb.FIND_EMPLOYEE_PAGE,nativeQuery = true)
    Page<Employee> findAll(Pageable pageable);
}
