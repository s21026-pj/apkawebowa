package com.zaliczenie.apkawebowa.model;

import org.hibernate.annotations.Check;

import javax.persistence.*;

@Entity
//@Check(constraints = "product_amount>=0")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String productMaker;
    private float price;
//    @Column
    private int amount;
    private String description;
    public enum Category{
        men, women, accessory;
    }
    Category category;

    public Product() {
    }

    public Product(Long id){
        this.id = id;
    }

    public Product(Long id, int amount){
        this.id = id;
        this.amount = amount;
    }

    public Product(String productName, String productMaker, float price, int amount, String description, Category category) {
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
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
