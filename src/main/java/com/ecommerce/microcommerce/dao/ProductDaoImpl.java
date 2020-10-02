package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao{

    public static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, new String("MacBook Pro"), 1250.46));
        products.add(new Product(2, new String("Samsung Tv"), 499.99));
        products.add(new Product(3, new String("Iphone 7 Plus"), 699.99));
    }


    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        for(Product product : products){
            if(product.getId() == id){
                return product;
            }
        }
        return null;
    }

    @Override
    public Product save(Product product) {
        products.add(product);
        return product;
    }
}
