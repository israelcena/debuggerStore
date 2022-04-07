package com.store.api.service;

import com.store.api.domain.Product;
import com.store.api.dto.ProductResponse;
import com.store.api.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public void create(Product product) {
        productRepository.save(product);
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream().map(ProductResponse::converter).collect(Collectors.toList());
    }

    public ProductResponse getProductByCode(UUID productCode){
        return ProductResponse.converter(productRepository.findByProductCode(productCode));
    }

}
