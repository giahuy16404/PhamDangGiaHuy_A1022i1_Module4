package com.example.furama.QueryDb;

public class QueryEmployeeDb {

    public static final String FIND_EMPLOYEE_PAGE = "SELECT * FROM employee ";

    public static final String SEARCH_BY_NAME_EMPLOYEE_PAGE = "SELECT * FROM employee  WHERE employee.name LIKE :name";
}
