package com.example.shop.repository;

import com.example.shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface iProductRepository extends JpaRepository<Product,Long> {

    @Query(name = QueryDb.FIND_BY_ID_PRODUCT,nativeQuery = true)
    Product findById(@Param("idProduct") long id);
}
