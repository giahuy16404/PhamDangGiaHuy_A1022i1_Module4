package com.repository;

public class QueryDB {
    public static String SHOW_LIST_PRODUCT = "SELECT * FROM product;";
    public static String ADD_PRODUCT = "INSERT INTO product(name,price,quantity) VALUES(?,?,?);";

    public static String REMOVE_PRODUCT = "DELETE FROM product WHERE product.id = ?;";

}
