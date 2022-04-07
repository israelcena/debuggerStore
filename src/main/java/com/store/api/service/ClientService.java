package com.store.api.service;

import com.store.api.domain.Client;
import com.store.api.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public void create(Client client) {
        clientRepository.save(client);
    }
}
