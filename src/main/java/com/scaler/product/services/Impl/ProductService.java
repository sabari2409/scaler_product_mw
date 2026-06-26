package com.scaler.product.services.Impl;

import com.scaler.product.dto.ProductDTO;
import com.scaler.product.dto.mapper.ProductMapper;
import com.scaler.product.model.Product;
import com.scaler.product.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Override
    public ProductDTO getProductById(int pId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        try {
            Product product = restTemplate.getForObject("https://fakestoreapi.com/products/" + pId, Product.class);
            if (product == null) {
                throw new NullPointerException("Product is null");
            }
            ProductMapper mapper = new ProductMapper();
            return mapper.toDTO(product);
        } catch (RuntimeException ex) {
            System.out.println("GET PRODUCT BY ID API EXCEPTION : " + ex.getMessage());
        }
        return null;
    }


    @Override
    public List<ProductDTO> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        try {
            ResponseEntity<List<Product>> productList = restTemplate.exchange("https://fakestoreapi.com/products", HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Product>>() {
                    });
            System.out.println("Products response -->" + Objects.requireNonNull(productList.getBody()).size());
            if (!productList.hasBody()) {
                throw new RuntimeException("Get products response is null");
            }
            ProductMapper mapper = new ProductMapper();
            return mapper.toDTOList(productList.getBody());
        } catch (RuntimeException ex) {
            System.out.println("Unable to call get products :  " + ex.getMessage());
        }
        return null;
    }

    @Override
    public Product create(Product product) {
        return null;
    }

    @Override
    public ProductDTO updateProduct(int id, ProductDTO product) {
        ProductMapper mapper = new ProductMapper();
        mapper.toEntity(product);
        ResponseEntity<Product> response = this.postForEntity("https://fakestoreapi.com/products/" + id, product, Product.class, id);
        ProductMapper mapper1 = new ProductMapper();

        if (!response.hasBody() || !response.getStatusCode().equals(HttpStatusCode.valueOf(200))) {
            throw new RuntimeException("Product update failed. Returned null response");
        }
        return mapper1.toDTO(Objects.requireNonNull(response.getBody()));
    }

    private <T> ResponseEntity<T> postForEntity(String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, HttpMethod.PUT, requestCallback, responseExtractor, uriVariables);
    }
}
