package com.example.shop.repository.product;

public class QueryDbProduct {
    public static final String FIND_BY_ID_PRODUCT = "SELECT * FROM product WHERE product.product_id = :idProduct";
}
