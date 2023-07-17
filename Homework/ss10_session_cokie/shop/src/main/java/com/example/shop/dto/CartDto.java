package com.example.shop.dto;

import com.example.shop.model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartDto {
    private Map<Product,Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public CartDto(Map<Product, Integer> productMap) {
        this.productMap = productMap;
    }

    public Map<Product, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<Product, Integer> productMap) {
        this.productMap = productMap;
    }
    public void addProduct(Product product){
        if (productMap.containsKey(product)){
            //Update + 1
            Integer currentValue =  productMap.get(product);
            productMap.replace(product,currentValue + 1);
        }else {
            productMap.put(product,1); //Lan dau dc them vao
        }
    }
    public void removeProduct(Product product){
        productMap.remove(product);
    }
    public Float totalPrice(){
        float total = 0;
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            total += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return total;
    }
}
