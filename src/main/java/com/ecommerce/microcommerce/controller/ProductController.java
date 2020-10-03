package com.ecommerce.microcommerce.controller;

import com.ecommerce.microcommerce.Exception.ProductNotFoundException;
import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.model.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Api(description = "Product Management")
@RestController //tells Spring that the methods come from this class
// Methods that respond to URI of the microservice
public class ProductController {

    @Autowired //let know to the controller that there is access to DAO and it will have to instanciate
    private ProductDao productDao;

    //Products
    @ApiOperation(value = "Get all Products")
    @GetMapping(value = "Products")
    public List<Product> listProducts() {
        return productDao.findAll();
    }

    //Products/{id}
    @ApiOperation(value = "Get a product by its ID")
    @GetMapping(value = "Products/{id}")
    public Product showOneProduct(@PathVariable int id) throws ProductNotFoundException {

        Product product = productDao.findById(id);
        if (product == null) {
            throw new ProductNotFoundException("Product with Id " + id + " does not exist");
        }

        return product;
    }

    @ApiOperation(value = "Add a product in the Database")
    @PostMapping(value = "/Products")
    public ResponseEntity<Void> addProduct(@RequestBody Product product) {

        Product productSave = productDao.save(product);
        if (product == null) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productSave.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value = "Delete a Product by its ID")
    @DeleteMapping(value = "/Products/{id}")
    public void deleteProduct(@PathVariable int id) throws ProductNotFoundException {
        Product product = productDao.deleteById(id);
        if (product == null) {
            throw new ProductNotFoundException("Product with Id " + id + " has been deleted");
        }
    }

    @GetMapping(value = "/test/products/{limitPrice}")
    public List<Product> testRequests(@PathVariable double limitPrice) {

        return productDao.findAnExpensiveProduct(limitPrice);
    }
}
