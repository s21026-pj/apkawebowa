package com.zaliczenie.apkawebowa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    private String productName;
    private String productMaker;

    public Product(String productName) {
        this.productName = productName;
    }

    public Product() {
    }

    public Product(String productMaker, String productName) {
        this.productName = productName;
        this.productMaker = productMaker;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductMaker() {
        return productMaker;
    }

    public void setProductMaker(String productMaker) {
        this.productMaker = productMaker;
    }
}
