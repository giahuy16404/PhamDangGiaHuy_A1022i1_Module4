package com.example.shop.repository.product;

import com.example.shop.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface iProductRepository extends JpaRepository<Product,Long> {

    @Query(name = QueryDbProduct.FIND_BY_ID_PRODUCT,nativeQuery = true)
    Product findById(@Param("idProduct") long id);
}
