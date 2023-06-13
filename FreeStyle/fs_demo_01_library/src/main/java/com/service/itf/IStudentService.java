package com.repository.itf;

import com.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll ();
}
