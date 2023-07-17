package com.example.furama.model.employee;

import com.example.furama.model.employee.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_degree_id")
    private long id;

    private String name;


    public EducationDegree() {
    }

    public EducationDegree(long id, String name) {
        this.id = id;
        this.name = name;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EducationDegree{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
