package com.scaler.product.services.fakestore_services_impl;

import com.scaler.product.model.fakestore_model.FakeStoreCategory;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class FakeStoreCategoryService implements IFakeStoreCategoryService {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Override
    public List<FakeStoreCategory> getCategories() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String[]> responseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/categories", String[].class);
        if (!responseEntity.hasBody()) {
            throw new RuntimeException("No response");
        }
        String[] response = responseEntity.getBody();
        List<FakeStoreCategory> fakeStoreCategoryList = new ArrayList<>();
        for (String category : Objects.requireNonNull(response, "Category response cannot be null")) {
            FakeStoreCategory category1 = new FakeStoreCategory();
            Long categoryId = Math.abs(ThreadLocalRandom.current().nextLong());
            category1.setId(categoryId);
            category1.setName(category);
            fakeStoreCategoryList.add(category1);
        }
        return fakeStoreCategoryList;
    }


    private <T> ResponseEntity<T> postForEntity(String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, HttpMethod.PUT, requestCallback, responseExtractor, uriVariables);
    }
}
