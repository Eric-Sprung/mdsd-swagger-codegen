package com.ecommerce.microcommerce.controller;

import com.ecommerce.microcommerce.Exception.ProductNotFoundException;
import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping(value = "/Products")
    public ResponseEntity<Void> addProduct(@RequestBody Product product){

        Product productSave = productDao.save(product);
        if (product == null){
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productSave.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/Products/{id}")
    public void deleteProduct(@PathVariable int id) throws ProductNotFoundException {
        Product product = productDao.deleteById(id);
        if(product == null){
            throw new ProductNotFoundException("id" + id);
        }
    }

    @GetMapping(value = "/test/products/{limitPrice}")
    public List<Product> testRequests(@PathVariable double limitPrice) {

        return productDao.findAnExpensiveProduct(limitPrice);
    }
}
