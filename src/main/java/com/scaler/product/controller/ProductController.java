package com.scaler.product.controller;

import com.scaler.product.dto.CategoryDTO;
import com.scaler.product.dto.ProductDTO;
import com.scaler.product.model.Product;
import com.scaler.product.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> productDTOList = this.productService.getAllProducts();
        return new ResponseEntity<>(productDTOList, HttpStatus.OK);
    }

    @GetMapping("{pId}")
    public ProductDTO getProductById(@PathVariable int pId) {
        return this.productService.getProductById(pId);
    }

    @PutMapping("{id}")
    public ProductDTO updateProductDetails(@PathVariable int id, @RequestBody ProductDTO request) {
        return this.productService.updateProduct(id, request);
    }
}