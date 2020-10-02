package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

// here we will expore all available methods
@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

    Product findById(int id);
    Product deleteById(int id);

    @Query("SELECT id, name, price FROM Product p WHERE p.price > :limitPrice")
    List<Product> findAnExpensiveProduct(@Param("limitPrice") double price);
}
