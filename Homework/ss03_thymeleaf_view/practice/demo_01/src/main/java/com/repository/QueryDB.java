package com.repository;

public class QueryDB {
    public static String SHOW_LIST_CUSTOMER = "SELECT * FROM customer;";
    public static String ADD_CUSTOMER = "INSERT INTO customer(name,email,address) VALUES(?,?,?);";

    public static String REMOVE_CUSTOMER = "DELETE FROM customer WHERE customer.id = ?;";

}
