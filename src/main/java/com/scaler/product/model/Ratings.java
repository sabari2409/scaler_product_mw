package com.scaler.product.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Ratings extends BaseModel {

    private Double rate;
    private Long count;

}
