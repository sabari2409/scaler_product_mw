package com.scaler.product.services.fakestore_services_impl;

import com.scaler.product.dto.falestore_dto.FakeStoreLoginRequestDto;
import com.scaler.product.dto.falestore_dto.FakeStoreLoginResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class FakeStoreAuthService implements IFakeStoreAuthService {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public MultiValueMap<String, String> login(FakeStoreLoginRequestDto fakeStoreLoginRequestDto) {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        try {
            HttpEntity<FakeStoreLoginRequestDto> httpEntity = new HttpEntity<>(fakeStoreLoginRequestDto);
            ResponseEntity<FakeStoreLoginResponseDto> responseEntity =
                    restTemplate.postForEntity(
                            "https://fakestoreapi.com/auth/login",
                            httpEntity,
                            FakeStoreLoginResponseDto.class);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set(HttpHeaders.SET_COOKIE, Objects.requireNonNull(responseEntity.getBody()).getToken());
            return httpHeaders;
        } catch (HttpClientErrorException ex) {
            return null;
        }
    }
}
