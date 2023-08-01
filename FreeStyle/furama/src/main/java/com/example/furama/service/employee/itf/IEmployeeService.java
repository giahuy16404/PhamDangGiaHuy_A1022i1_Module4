package com.example.furama.service.employee.itf;

import com.example.furama.model.employee.Division;
import com.example.furama.model.employee.EducationDegree;
import com.example.furama.model.employee.Employee;
import com.example.furama.model.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService{
    boolean add(Employee employee);
    boolean update(Employee employee);
    List<EducationDegree> findEducation();
    List<Position> findPosition();
    List<Division> findDivision();
    Page<Employee> findAll(Pageable pageable);

}
