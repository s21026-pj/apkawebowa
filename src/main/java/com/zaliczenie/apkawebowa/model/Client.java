package com.zaliczenie.apkawebowa.model;

import javax.persistence.*;


@Entity
public class Client {
    @Id
    @GeneratedValue
    private Long id;

    private String clientName;
    private String clientSurName;


    public Client() {
    }
    public Client(String clientName, String clientSurName) {
        this.clientName = clientName;
        this.clientSurName = clientSurName;
    }

}
