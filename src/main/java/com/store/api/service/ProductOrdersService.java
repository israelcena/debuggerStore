package com.store.api.service;

import com.store.api.domain.Customer;
import com.store.api.domain.Product;
import com.store.api.domain.ProductOrders;
import com.store.api.dto.ProductOrderResponse;
import com.store.api.dto.ProductOrdersRequest;
import com.store.api.repository.CustomerRepository;
import com.store.api.repository.ProductOrdersRepository;
import com.store.api.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductOrdersService {

    private final ProductOrdersRepository productOrdersRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

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
        return customerRepository.findById(clientId);
    }

    public List<ProductOrderResponse> getAllOrders() {
        return productOrdersRepository.findAll().stream().map(ProductOrderResponse::converter).collect(Collectors.toList());
    }

    public List<ProductOrderResponse> getOrderByDocument(String document){
       Customer customer = customerRepository.findByDocument(document);
       return customer.getProductOrdersList().stream().map(ProductOrderResponse::converter).collect(Collectors.toList());
    }

}
