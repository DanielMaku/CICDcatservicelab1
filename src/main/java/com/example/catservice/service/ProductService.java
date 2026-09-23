package com.example.catservice.service;

import com.example.catservice.model.Product;
import com.example.catservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getAll() {
        return productRepository.findAll();
    }
    public Product create(Product product) {
        product.setId(null);
        return productRepository.save(product);
    }
}
