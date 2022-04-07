package com.store.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ProductOrdersDTO {
    private List<Long> productIdList;
    private Long clientId;
}
