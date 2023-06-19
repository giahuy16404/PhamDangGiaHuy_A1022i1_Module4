package com.codegym.service;

import com.codegym.model.Student;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements IServiceStudent{
    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public String showMessage() {
        return "hello studentService";
    }
}
