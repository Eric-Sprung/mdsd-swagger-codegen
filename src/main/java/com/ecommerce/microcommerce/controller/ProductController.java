package com.ecommerce.microcommerce.controller;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //tells Spring that the methods come from this class
// Methods that respond to URI of the microservice
public class ProductController {

    @Autowired //let know to the controller that there is access to DAO and it will have to instanciate
    private ProductDao productDao;

    //Products
    @GetMapping(value = "Products")
    public List<Product> listProducts(){
        return productDao.findAll();
    }

    //Products/{id}
    @GetMapping(value = "Products/{id}")
    public Product showOneProduct(@PathVariable int id){
        return productDao.findById(id);
    }
}
