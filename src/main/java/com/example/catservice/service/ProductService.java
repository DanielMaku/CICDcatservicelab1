package com.example.catservice.service;

import com.example.catservice.dto.CreateProductRequest;
import com.example.catservice.model.Category;
import com.example.catservice.model.Product;
import com.example.catservice.repository.CategoryRepository;
import com.example.catservice.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;



    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    public List<Product> getAll() {
        return productRepository.findAll();
    }
    public Product create(Product product) {
        product.setId(null);
        return productRepository.save(product);
    }

    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with id"+ id +"Product not found"));

    }
public List<Product> getByMinimumPrice(BigDecimal minPrice)
{
    return productRepository.findByMinPrice(minPrice);
}

    public Product createProduct(CreateProductRequest request) {
        if (request.categoryId() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "categoryId is required");
        }
        Category category = categoryRepository
                .findById(request.categoryId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Category does not exist"));
        Product product = new Product();
        product.setName(request.name());
        product.setPrice(request.price());
        product.setCategory(category);
        return productRepository.save(product);
    }
    public List<Product> getByCategoryName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }
}
