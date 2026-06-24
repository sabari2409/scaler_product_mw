package com.scaler.product.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class BaseModel {
    private int id;
    private UUID uuid;
    private Date createdDate;
    private Date updatedDate;
    private Boolean isActive;

}
