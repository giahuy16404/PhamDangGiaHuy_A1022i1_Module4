package com.example.furama.QueryDb;

public class EmployeeQueryDb {

    public static final String FIND_EMPLOYEE_PAGE = "SELECT * FROM employee \n" +
            "JOIN division ON division.division_id = employee.division_id\n" +
            "JOIN education_degree ON education_degree.education_degree_id = employee.education_degree_id\n" +
            "JOIN position ON position.position_id = employee.employee_id";
}
