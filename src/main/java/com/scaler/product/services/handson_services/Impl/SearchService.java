package com.scaler.product.services.handson_services.Impl;

import com.scaler.product.dto.handson_dto.SearchReqDTO;
import com.scaler.product.dto.handson_dto.SearchReqMultiCriteriaSortDTO;
import com.scaler.product.dto.handson_dto.SearchRespDTO;
import com.scaler.product.model.handson_model.Product;
import com.scaler.product.services.handson_services.IProductService;
import com.scaler.product.services.handson_services.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService implements ISearchService {

    @Autowired
    private IProductService productService;

    @Override
    public SearchRespDTO search(SearchReqDTO reqDTO) {
        Sort sortByIdDesc = Sort.by("id").descending();
        Sort sortByPriceDesc = Sort.by("price").descending();
        Sort sort = sortByPriceDesc.and(sortByIdDesc);
        Page<Product> products = this.productService.findBypName(reqDTO.getQuery(), PageRequest.of(reqDTO.getPageNo(), reqDTO.getPageSize(), sort));
        SearchRespDTO searchRespDTO = new SearchRespDTO();
        searchRespDTO.setSearchResults(products);
        return searchRespDTO;
    }


    /**
     * Apply custom sort
     *
     * @param reqMultiCriteriaSortDTO
     * @return
     */
    @Override
    public SearchRespDTO searchAndPerformMultiCriteriaSort(SearchReqMultiCriteriaSortDTO reqMultiCriteriaSortDTO) {
        List<Sort.Order> orders = reqMultiCriteriaSortDTO
                .getMultiSortSearchCriteriaList()
                .stream()
                .map(multiSortSearchCriteria -> new Sort.Order(
                        Sort.Direction.fromString(multiSortSearchCriteria.getDirection()),
                        multiSortSearchCriteria.getField()
                ))
                .toList();
        Sort sort = Sort.by(orders);
        int pageNo = reqMultiCriteriaSortDTO.getPageNo();
        int pageSize = reqMultiCriteriaSortDTO.getPageSize();
        Page<Product> products = this.productService.findBypName(
                reqMultiCriteriaSortDTO.getQuery(),
                PageRequest.of(pageNo, pageSize, sort)
        );
        SearchRespDTO searchRespDTO = new SearchRespDTO();
        searchRespDTO.setSearchResults(products);
        return searchRespDTO;
    }

    /**
     * Apply sort by comma separated values in url
     *
     * @param categoryId
     * @param subCategoryId
     * @param pageable
     * @return
     */
    @Override
    public SearchRespDTO searchAndPerformMultiSortByComma(Long categoryId, Long subCategoryId, Pageable pageable) {
        Page<Product> products = this.productService.findByCategoryIdAndSubCategoryId(categoryId, subCategoryId, pageable);
        SearchRespDTO searchRespDTO = new SearchRespDTO();
        searchRespDTO.setSearchResults(products);
        return searchRespDTO;
    }
}
