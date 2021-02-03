package com.zaliczenie.apkawebowa.controller;

import com.zaliczenie.apkawebowa.model.Client;
import com.zaliczenie.apkawebowa.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientControler {

    private ClientService clientService;

    public ClientControler(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Client> save(@RequestBody Client client){
        return  ResponseEntity.ok(clientService.save(client));
    }

}
