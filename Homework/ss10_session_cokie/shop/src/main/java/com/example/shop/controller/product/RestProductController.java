package com.example.shop.controller.product;

import com.example.shop.dto.product.ProductDto;
import com.example.shop.model.product.Product;
import com.example.shop.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("api/product")
public class RestProductController {
    @Autowired
    private IProductService iProductService;

    @PatchMapping("/update")
    public ResponseEntity<?> update(@RequestBody Product product) {
        if (iProductService.update(product)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<Product>> getAll(@RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "0") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> getAll = iProductService.findAll(pageable);
        if (getAll.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(getAll, HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<Product> findById(@RequestParam long id) {
        Product product = iProductService.findById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
