package com.scaler.product.controller.handson_controller;

import com.scaler.product.dto.handson_dto.SearchReqDTO;
import com.scaler.product.dto.handson_dto.SearchReqMultiCriteriaSortDTO;
import com.scaler.product.dto.handson_dto.SearchRespDTO;
import com.scaler.product.services.handson_services.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("search")
public class SearchController {

    @Autowired
    private ISearchService searchService;


    @PostMapping
    public ResponseEntity<SearchRespDTO> search(@RequestBody SearchReqDTO request) {
        SearchRespDTO searchRespDTO = this.searchService.search(request);
        return ResponseEntity.ok(searchRespDTO);
    }

    @PostMapping("msc")
    public ResponseEntity<SearchRespDTO> searchAndPerformMultiCriteriaSort(@RequestBody SearchReqMultiCriteriaSortDTO request) {
        SearchRespDTO searchRespDTO = this.searchService.searchAndPerformMultiCriteriaSort(request);
        return ResponseEntity.ok(searchRespDTO);
    }


    //    GET /search?categoryId=10&subCategoryId=5&sort=price,desc&sort=id,desc&sort=rating,desc
    @GetMapping("mscByComma")
    public ResponseEntity<SearchRespDTO> searchAndPerformMultiSortByComma(@RequestParam Long categoryId,
                                                                          @RequestParam Long subCategoryId,
                                                                          @PageableDefault(size = 4) Pageable pageable) {
        SearchRespDTO searchRespDTO = this.searchService.searchAndPerformMultiSortByComma(categoryId, subCategoryId, pageable);
        return ResponseEntity.ok(searchRespDTO);
    }
}
