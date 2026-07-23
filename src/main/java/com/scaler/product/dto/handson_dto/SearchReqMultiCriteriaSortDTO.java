package com.scaler.product.dto.handson_dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchReqMultiCriteriaSortDTO extends SearchReqDTO {
    List<MultiSortSearchCriteria> multiSortSearchCriteriaList;
}
