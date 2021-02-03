package com.zaliczenie.apkawebowa.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Cart {

    @Id
    @GeneratedValue
    private Long id;

    public Cart() {
    }

//    @OneToMany(cascade = CascadeType.ALL, mappedBy= "cart")
//    private List<Order> items = new ArrayList<>();

//    public List<Order> getItems() {
//        return items;
//    }

//    public void setItems(List<Order> items) {
//        this.items = items;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
