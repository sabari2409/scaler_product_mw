package com.scaler.product.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CategoryDTO {

    private int id;
    private String name;
    private String description;
    private Boolean isActive;
}
