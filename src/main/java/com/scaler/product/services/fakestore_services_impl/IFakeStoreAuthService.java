package com.scaler.product.services.fakestore_services_impl;

import com.scaler.product.dto.falestore_dto.FakeStoreLoginRequestDto;
import org.springframework.util.MultiValueMap;

public interface IFakeStoreAuthService {
    MultiValueMap<String, String> login(FakeStoreLoginRequestDto fakeStoreLoginRequestDto);
}
