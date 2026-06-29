package com.scaler.product.controller;

import com.scaler.product.dto.CategoryDTO;
import com.scaler.product.dto.CategoryReqDTO;
import com.scaler.product.exception.InvalidCategoryException;
import com.scaler.product.services.ICategoryService;
import jakarta.validation.Valid;
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
    public ResponseEntity<CategoryDTO> create(@Valid @RequestBody CategoryReqDTO req) {
        try {
            CategoryDTO response = this.categoryService.create(req);
            if (response == null) {
                throw new InvalidCategoryException("Null Pointer Exception ");
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            throw new InvalidCategoryException(e.getMessage());
        }
    }

}
