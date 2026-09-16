package com.example.catservice.controller;

import com.example.catservice.model.Product;
import com.example.catservice.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
@GetMapping
    public List<Product> getProducts(){
        return productService.getAll();
    }

    @PostMapping
    public Product createProduct(@RequestBody  Product product){
        return productService.create(product);
    }
}
