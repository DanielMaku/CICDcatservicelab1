package com.example.catservice.controller;

import com.example.catservice.dto.CreateProductRequest;
import com.example.catservice.model.Product;
import com.example.catservice.repository.ProductRepository;
import com.example.catservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    private final ProductService productService;
   // private final ProductRepository productRepository;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
@GetMapping
    public List<Product> getProducts(){
        return productService.getAll();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody CreateProductRequest request) {
        return productService.createProduct(request);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable long id){
        return productService.getById(id);
    }

    @GetMapping("/min-price")
    public List<Product> getByMinimumPrice(
            @RequestParam("price") BigDecimal price)
    {
        return productService.getByMinimumPrice(price);
    }

    @GetMapping("/by-category")
    public List<Product> getByCategory(
            @RequestParam("name") String categoryName) {
        return productService.getByCategoryName(categoryName);
    }

}
