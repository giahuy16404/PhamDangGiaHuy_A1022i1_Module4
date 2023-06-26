package com.service;

import com.model.Product;
import com.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository iProductRepository;

    @Override
    public List<Product> showList() {
        List<Product> products  = iProductRepository.showList();
        Locale locale = new Locale("vi","VN");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        for (Product p:products) {
            format.format(p.getPrice());
        }
        return products;
    }

    @Override
    public boolean add(Product product) {
        if (iProductRepository.add(product)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(int remove) {
        if (iProductRepository.remove(remove)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean edit(Product product) {
        if (iProductRepository.edit(product)) {
            return true;
        }
        return false;
    }
}
