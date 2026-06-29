package com.scaler.product.dto;

import com.scaler.product.dto.mapper.RatingsDTO;
import com.scaler.product.model.Category;
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
    private Category category;
    private String image;
    private RatingsDTO rating;
}
