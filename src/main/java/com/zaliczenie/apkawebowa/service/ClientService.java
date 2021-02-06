package com.zaliczenie.apkawebowa.service;

import com.zaliczenie.apkawebowa.model.Client;
import com.zaliczenie.apkawebowa.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public Client getClientByLogin(String customerLogin) {
        return clientRepository.findAll().stream().filter(Client -> customerLogin.equals(Client.getClientLogin())).findFirst().orElse(null);
    }

    public boolean checkIfExistLogin(String customerLogin) {
        Client foundClient = clientRepository.findAll().stream().filter(Client -> customerLogin.equals(Client.getClientLogin())).findFirst().orElse(null);
        if (foundClient == null) {
            return false;
        }
        return true;
    }
}
