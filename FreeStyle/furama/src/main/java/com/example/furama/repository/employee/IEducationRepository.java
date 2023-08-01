package com.example.furama.repository.employee;

import com.example.furama.model.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducationRepository extends JpaRepository<EducationDegree,Long> {
}
