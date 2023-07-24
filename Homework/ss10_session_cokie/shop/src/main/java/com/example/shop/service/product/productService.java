package com.example.shop.service.product;

import com.example.shop.model.product.Product;
import com.example.shop.repository.product.iProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class productService implements IProductService {

    @Autowired
    private iProductRepository iProductRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public boolean create(Product product) {
        try {
            iProductRepository.save(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Product product) {
        Product product1 = iProductRepository.findById(product.getId());
        if (product1 == null) {
            return false;
        }
        iProductRepository.save(product);
        return true;
    }

    @Override
    public Product findById(long id) {
        return iProductRepository.findById(id);
    }
}
