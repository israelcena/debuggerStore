package com.store.api.controller;


import com.store.api.dto.ProductOrdersRequest;
import com.store.api.service.ProductOrdersService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/store/order")
public class ProductOrdersController {

    private final ProductOrdersService productOrdersService;

    @PostMapping()
    public ResponseEntity<String> create(@RequestBody ProductOrdersRequest ordersDTO){
        productOrdersService.create(ordersDTO);
        return new ResponseEntity<String>("Order registered successfully", HttpStatus.OK);
    }
}
