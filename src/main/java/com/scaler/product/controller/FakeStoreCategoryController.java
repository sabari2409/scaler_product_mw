package com.scaler.product.controller;

import com.scaler.product.model.FakeStoreCategory;
import com.scaler.product.services.IFakeStoreCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class FakeStoreCategoryController {

    @Autowired
    private IFakeStoreCategoryService fakeStoreCategoryService;


    @GetMapping("all")
    public List<FakeStoreCategory> getAllCategories() {
        return this.fakeStoreCategoryService.getCategories();
    }


}
