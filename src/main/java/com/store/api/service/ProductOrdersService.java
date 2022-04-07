package com.store.api.service;

import com.store.api.domain.Customer;
import com.store.api.domain.Product;
import com.store.api.domain.ProductOrders;
import com.store.api.dto.ProductOrdersRequest;
import com.store.api.repository.ClientRepository;
import com.store.api.repository.ProductOrdersRepository;
import com.store.api.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductOrdersService {

    private final ProductOrdersRepository productOrdersRepository;
    private final ProductRepository productRepository;
    private final ClientRepository clientRepository;

    public void create(ProductOrdersRequest ordersDTO) {
        ProductOrders orders = new ProductOrders();
        orders.setCustomers(List.of(getClientById(ordersDTO.getClientId()).get()));
        orders.setProducts(getProductsByIds(ordersDTO.getProductIdList()));
        productOrdersRepository.save(orders);
    }

    private List<Product> getProductsByIds(List<Long> productsIds){
        return productRepository.findAllById(productsIds);
    }

    private Optional<Customer> getClientById(Long clientId) {
        return clientRepository.findById(clientId);
    }

    public List<ProductOrders> getAllOrders() {
        return productOrdersRepository.findAll();
    }

}
