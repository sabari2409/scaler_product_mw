package com.scaler.product.dto.sorting_pagination.assignment_1;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserSearchRequestDto {
    private String query;
    private Integer pageNumber;
}
