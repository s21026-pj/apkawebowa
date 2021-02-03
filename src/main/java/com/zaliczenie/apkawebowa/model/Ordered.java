package com.zaliczenie.apkawebowa.model;

import javax.persistence.*;


@Entity
public class Ordered {
    @Id
    @GeneratedValue
    private Long id;

    private int orderAmount;
    private Long productId;
    private String customerLogin;

    public Ordered(){
    }


    public Ordered(Long productId){
        this.productId=productId;
    }

    public Ordered(int orderAmount, Long productId, String customerLogin){
        this.orderAmount = orderAmount;
        this.productId = productId;
        this.customerLogin = customerLogin;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getCustomerLogin() {
        return customerLogin;
    }

    public void setCustomerLogin(String customerLogin) {
        this.customerLogin = customerLogin;
    }

}
