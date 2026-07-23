package com.scaler.product.controller.handson_controller;


import com.scaler.product.dto.handson_dto.SubCategoryReqDTO;
import com.scaler.product.model.handson_model.SubCategory;
import com.scaler.product.services.handson_services.ISubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("subCategory")
public class SubCategoryController {

    @Autowired
    private ISubCategoryService subCategoryService;

    @PostMapping
    public SubCategory create(@RequestBody SubCategoryReqDTO request) {
        return this.subCategoryService.create(request);
    }
}
