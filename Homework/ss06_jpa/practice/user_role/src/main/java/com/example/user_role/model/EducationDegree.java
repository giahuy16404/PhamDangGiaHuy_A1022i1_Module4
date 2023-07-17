package com.example.user_role.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ida;

    private String name;

    @OneToMany(mappedBy = "educationDegree")
    private Set<Employee> employees;

    public EducationDegree() {
    }

    public EducationDegree(long id, String name, Set<Employee> employees) {
        this.ida = id;
        this.name = name;
        this.employees = employees;
    }

    public long getId() {
        return ida;
    }

    public void setId(long id) {
        this.ida = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "EducationDegree{" +
                "id=" + ida +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
