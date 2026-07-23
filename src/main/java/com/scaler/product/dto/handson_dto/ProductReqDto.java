package com.scaler.product.dto.handson_dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductReqDto {

    private String name;
    private String description;
    private Double Price;
    private String category;
    private String subCategory;
}
