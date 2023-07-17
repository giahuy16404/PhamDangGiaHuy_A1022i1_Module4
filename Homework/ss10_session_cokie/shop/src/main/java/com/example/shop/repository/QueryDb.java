package com.example.shop.repository;

public class QueryDb {
    public static final String FIND_BY_ID_PRODUCT = "SELECT * FROM product WHERE product.product_id = :idProduct";
}
