package com.scaler.product.controller;

import com.scaler.product.services.IFakeStoreProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class FakeStoreProductController {

    @Autowired
    private IFakeStoreProductService fakeStoreProductService;


    @DeleteMapping("{productId}")
    public void deleteProductById(@PathVariable("productId") Long productId) {
        System.out.println("Controller product id -->" + productId);
        this.fakeStoreProductService.deleteProduct(productId);
    }

}
