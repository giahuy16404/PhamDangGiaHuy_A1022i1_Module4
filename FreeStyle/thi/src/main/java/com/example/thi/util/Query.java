package com.example.test_1.util;

public class Query {
    public static final String FIND_PAGE_AND_SEARCH = "SELECT * FROM customer JOIN customer_type ON customer.type_id = customer_type.type_id WHERE customer.name " +
            "LIKE :valueSearch OR customer_type.name LIKE :valueSearch";
}
