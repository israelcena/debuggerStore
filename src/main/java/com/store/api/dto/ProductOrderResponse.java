package com.store.api.dto;

import com.store.api.domain.Product;
import com.store.api.domain.ProductOrders;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter @Setter
public class ProductOrderResponse {
    private UUID orderCode;
    private ZonedDateTime orderTime;
    private List<ProductResponse> products;

    public static ProductOrderResponse converter(ProductOrders productOrders) {
        ProductOrderResponse productOrderResponse = new ProductOrderResponse();
        productOrderResponse.setOrderCode(productOrders.getOrderCode());
        productOrderResponse.setOrderTime(productOrders.getOrderTime());
        productOrderResponse.setProducts(productOrders.getProducts().stream().map(ProductResponse::converter).collect(Collectors.toList()));

        return productOrderResponse;
    }
}
