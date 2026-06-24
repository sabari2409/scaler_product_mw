package com.scaler.product.dto;

import com.scaler.product.model.Ratings;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductDTO {
    private int id;
    private String title;
    private String description;
    private Double Price;
    private String category;
    private String image;
    private Ratings rating;
}
