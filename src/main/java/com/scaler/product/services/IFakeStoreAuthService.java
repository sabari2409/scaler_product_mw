package com.scaler.product.services;

import com.scaler.product.dto.FakeStoreLoginRequestDto;
import org.springframework.util.MultiValueMap;

public interface IFakeStoreAuthService {
    MultiValueMap<String, String> login(FakeStoreLoginRequestDto fakeStoreLoginRequestDto);
}
