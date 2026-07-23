package com.scaler.product.dto.handson_dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchReqDTO {

    private String query;
    private int pageNo;
    private int pageSize;
}
