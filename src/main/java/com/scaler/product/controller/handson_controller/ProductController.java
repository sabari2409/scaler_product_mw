package com.scaler.product.controller.handson_controller;


import com.scaler.product.dto.handson_dto.ProductReqDto;
import com.scaler.product.dto.handson_dto.ProductResDTO;
import com.scaler.product.exception.ProductException;
import com.scaler.product.model.handson_model.Product;
import com.scaler.product.services.handson_services.ICategoryService;
import com.scaler.product.services.handson_services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;


    @PostMapping
    public ResponseEntity<ProductResDTO> create(@RequestBody ProductReqDto request) {
        if (request == null) throw new ProductException("Request is null");
        if (Objects.equals(request.getName(), "") ||
                Objects.equals(request.getCategory(), "") ||
                Objects.equals(request.getSubCategory(), ""))
            throw new ProductException("Some Product Details are empty");
        ProductResDTO product = this.productService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
}
