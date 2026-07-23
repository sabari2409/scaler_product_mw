package com.scaler.product.dto.handson_dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter
@Setter
public class MultiSortSearchCriteria {
    private String field;
    private String direction;
}
