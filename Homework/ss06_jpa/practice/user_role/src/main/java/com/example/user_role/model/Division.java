package com.example.user_role.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idd;
    private String name;

    @OneToMany(mappedBy = "division")
    private Set<Employee> employees;

    public Division() {
    }

    public Division(long id, String name, Set<Employee> employees) {
        this.idd = id;
        this.name = name;
        this.employees = employees;
    }

    public long getId() {
        return idd;
    }

    public void setId(long id) {
        this.idd = id;
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
        return "Division{" +
                "id=" + idd +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
