package com.zaliczenie.apkawebowa.controller;

import com.zaliczenie.apkawebowa.exceptions.NoSuchUserException;
import com.zaliczenie.apkawebowa.exceptions.RepetedUserException;
import com.zaliczenie.apkawebowa.model.Client;
import com.zaliczenie.apkawebowa.model.Ordered;
import com.zaliczenie.apkawebowa.service.ClientService;
import com.zaliczenie.apkawebowa.service.OrderedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientControler {

    private ClientService clientService;
    @Autowired
    private OrderedService orderedService;

    public ClientControler(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Client> save(@RequestBody Client client) throws RepetedUserException {
        return ResponseEntity.ok(clientService.save(client));
    }

    @GetMapping("/{login}")
    public ResponseEntity<Client> checkIfExistLogin(@PathVariable String login) {
        Client lookedClient = clientService.getClientByLogin(login);
        if (lookedClient != null) {
            return ResponseEntity.ok(lookedClient);
        }
        throw new NoSuchUserException();
    }

    @PostMapping("/{customerId}")
    public List<Ordered> finalize(@PathVariable Long customerId) {
        return orderedService.finalizeOrder(customerId);
    }
}
