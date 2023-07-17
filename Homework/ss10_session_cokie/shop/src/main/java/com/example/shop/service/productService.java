package com.example.shop.service;

import com.example.shop.model.Product;
import com.example.shop.repository.iProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productService implements IProductService{

    @Autowired
    iProductRepository iProductRepository;
    @Override
    public Page<Product> findAll(Pageable pageable) {
       return  iProductRepository.findAll(pageable);
    }

    @Override
    public boolean create(Product product) {
        try {
            iProductRepository.save(product);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Product findById(long id) {
        return iProductRepository.findById(id);
    }
}
