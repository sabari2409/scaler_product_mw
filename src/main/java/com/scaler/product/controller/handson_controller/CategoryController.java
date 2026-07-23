package com.scaler.product.controller.handson_controller;


import com.scaler.product.dto.handson_dto.CategoryReqDTO;
import com.scaler.product.model.handson_model.Category;
import com.scaler.product.services.handson_services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;


    @PostMapping
    public ResponseEntity<Category> create(@RequestBody CategoryReqDTO reqDTO) {
        Category category = this.categoryService.create(reqDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }
}
