package com.example.catservice.controller;

import com.example.catservice.model.Product;
import com.example.catservice.service.ProductService;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody  Product product){
        return productService.create(product);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable long id){
        return productService.getById(id);
    }
}
