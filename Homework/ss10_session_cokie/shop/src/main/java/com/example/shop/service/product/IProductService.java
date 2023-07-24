package com.example.shop.service.product;

import com.example.shop.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);
    boolean create(Product product);
    boolean update(Product product);

    Product findById(@Param("idProduct") long id);


}
