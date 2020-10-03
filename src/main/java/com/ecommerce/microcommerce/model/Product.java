package com.ecommerce.microcommerce.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@JsonIgnoreProperties(value = {"purchasePrice"})
@Entity
public class Product {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private double price;

    //Do Not Show it to users with
    //@JsonIgnore or @JsonIgnoreProperties
    private double purchasePrice;


    //Constructor
    public Product(int id, String name, double price, double purchasePrice) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.purchasePrice = purchasePrice;
    }

    //default constructor
    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    //For the serialization
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", purchasePrice=" + purchasePrice +
                '}';
    }
}
