package com.service;

import com.model.Product;
import com.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {
@Autowired
IProductRepository iProductRepository;
    @Override
    public List<Product> showList() {
        return iProductRepository.showList();
    }

    @Override
    public boolean add(Product product) {
        if (iProductRepository.add(product)){
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(int remove) {
        if (iProductRepository.remove(remove)){
            return true;
        }
        return false;
    }

    @Override
    public boolean edit(Product product) {
        if (iProductRepository.edit(product)){
            return true;
        }
        return false;
    }
}
