package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.Product;

import java.util.List;

// here we will expore all available methods
public interface ProductDao {

    public List<Product> findAll(); // return all available Products
    public Product findById(int id); // retrun a product by its ID
    public Product save(Product product); // add or update a product
}
