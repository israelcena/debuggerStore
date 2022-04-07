package com.store.api.service;

import com.store.api.domain.Customer;
import com.store.api.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CustomerService {

    private final ClientRepository clientRepository;

    public void create(Customer customer) {
        clientRepository.save(customer);
    }

    public List<Customer> getCustomers() {
        return clientRepository.findAll();
    }

}
