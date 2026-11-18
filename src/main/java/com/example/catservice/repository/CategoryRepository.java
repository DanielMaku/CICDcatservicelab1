package com.example.catservice.repository;

import com.example.catservice.model.Category;
import com.example.catservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query("""
 SELECT p
 FROM Product p
 JOIN p.category c
 WHERE LOWER(c.name) = LOWER(:categoryName)
 ORDER BY p.price ASC
 """)
    List<Product> findByCategoryName(
            @Param("categoryName") String categoryName);

}
