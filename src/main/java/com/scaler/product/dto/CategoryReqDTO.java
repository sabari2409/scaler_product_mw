package com.scaler.product.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryReqDTO {

    @NotBlank(message = "Category name cannot be blank")
    private String name;
    @NotBlank(message = "Category description cannot be blank")
    private String description;
}
