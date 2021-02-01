package com.zaliczenie.apkawebowa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

    public enum Category{
        men, women, kid, accessory;

    }
    @Id
    @GeneratedValue
    private Long id;
    private String productName;
    private String productMaker;
    private int price;
    private int amount;
    private String description;
    Category category;

    public Product() {
    }

    public Product(String productName, String productMaker, int price, int amount, String description, Category category) {
        this.productName = productName;
        this.productMaker = productMaker;
        this.price = price;
        this.amount = amount;
        this.description = description;
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public Product(String productName) {
        this.productName = productName;
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
