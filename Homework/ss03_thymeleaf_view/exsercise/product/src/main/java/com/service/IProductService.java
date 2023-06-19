package com.service;

import com.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showList();
    boolean add(Product product);
    boolean remove(int remove);
    boolean edit(Product product);

}
