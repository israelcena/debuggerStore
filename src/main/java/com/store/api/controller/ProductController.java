package com.store.api.controller;

import com.store.api.domain.Product;
import com.store.api.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/store/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping()
    public ResponseEntity<String> create(@RequestBody Product product) {
        productService.create(product);
        return new ResponseEntity<>("Product registered successfully", HttpStatus.OK);
    }
}
