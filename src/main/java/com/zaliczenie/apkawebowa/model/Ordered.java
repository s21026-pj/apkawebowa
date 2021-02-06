package com.zaliczenie.apkawebowa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ordered {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int orderAmount;
    private Long productId;
    private String customerLogin;

    public enum Status {
        open, closed, send, toPrepare;
    }

    Status status = Status.open;
    private Long finalId;

    public Ordered() {
    }


    public Ordered(Long productId) {
        this.productId = productId;
    }

    public Ordered(int orderAmount, Long productId, String customerLogin) {
        this.orderAmount = orderAmount;
        this.productId = productId;
        this.customerLogin = customerLogin;
    }

    public Long getFinalId() {
        return finalId;
    }

    public void setFinalId(Long finalId) {
        this.finalId = finalId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
