package com.ecommerce.microcommerce.Exception;

public class ProductNotFoundException extends Throwable {
    public ProductNotFoundException(String s) {
        s = "No Product Found !!!";
        System.out.println(s);
    }
}
