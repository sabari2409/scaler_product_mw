package com.scaler.product.services.Impl;


import com.scaler.product.services.IFakeStoreProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements IFakeStoreProductService {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Override
    public void deleteProduct(Long productId) {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        restTemplate.delete("https://fakestoreapi.com/products/{productId}", productId);
    }
}