package com.repository;

import com.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> showList();
    boolean add(Product product);
    boolean remove(int remove);
    boolean edit(Product product);

}
