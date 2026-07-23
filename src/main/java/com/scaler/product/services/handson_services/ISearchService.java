package com.scaler.product.services.handson_services;

import com.scaler.product.dto.handson_dto.SearchReqDTO;
import com.scaler.product.dto.handson_dto.SearchReqMultiCriteriaSortDTO;
import com.scaler.product.dto.handson_dto.SearchRespDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISearchService {
    SearchRespDTO search(SearchReqDTO reqDTO);

    SearchRespDTO searchAndPerformMultiCriteriaSort(SearchReqMultiCriteriaSortDTO reqMultiCriteriaSortDTO);

    SearchRespDTO searchAndPerformMultiSortByComma(Long categoryId, Long subCategoryId, Pageable pageable);
}
