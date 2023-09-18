package com.example.furama.QueryDb;

public class QueryCustomerDb {
    public static final String FIND_CUSTOMER_PAGE = "SELECT * FROM customer\n" +
            "JOIN customer_type ON customer.customer_type_id = customer_type.customer_type_id";
    public static final String FIND_BY_NAME = "SELECT * FROM customer\n" +
            "JOIN customer_type ON customer.customer_type_id = customer_type.customer_type_id WHERE customer.name LIKE :name";
    public static final String DELETE_CUSTOMER = " DELETE FROM customer WHERE customer_id = :id ";
    public static final String DELETE_CONTRACT_BY_CUSTOMER = "DELETE FROM contract WHERE customer_id = :id ;";
}
