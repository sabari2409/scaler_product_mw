package com.scaler.product.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CategoryDTO {

    private UUID uuid;
    private String description;
    private String name;
}
