package com.store.api.service;

import com.store.api.domain.Product;
import com.store.api.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public void create(Product product) {
        productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductByCode(UUID productCode){
        return productRepository.findByProductCode(productCode);
    }

}
