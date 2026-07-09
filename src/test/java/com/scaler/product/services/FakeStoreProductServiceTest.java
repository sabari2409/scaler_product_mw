package com.scaler.product.services;


import com.scaler.product.services.Impl.FakeStoreProductService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@SpringBootTest
public class FakeStoreProductServiceTest {

    @MockitoBean
    private RestTemplateBuilder restTemplateBuilder;

    @MockitoBean
    private RestTemplate restTemplate;

    @Autowired
    private FakeStoreProductService fakeStoreProductService;

    @BeforeEach
    public void setUp() {
        when(restTemplateBuilder.build()).thenReturn(restTemplate);
    }

    @Test
    public void testDeleteProduct() {
        Long productId = 1L;

        doNothing().when(restTemplate).delete(eq("https://fakestoreapi.com/products/{productId}"), eq(productId));

        fakeStoreProductService.deleteProduct(productId);

        verify(restTemplate).delete(eq("https://fakestoreapi.com/products/{productId}"), eq(productId));
    }
}
