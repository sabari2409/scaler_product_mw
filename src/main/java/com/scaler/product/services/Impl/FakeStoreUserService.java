package com.scaler.product.services.Impl;


import com.scaler.product.dto.FakeStoreUserAddressDto;
import com.scaler.product.dto.FakeStoreUserCreatedResponseDto;
import com.scaler.product.dto.FakeStoreUserDto;
import com.scaler.product.dto.FakeStoreUserNameDto;
import com.scaler.product.model.Address;
import com.scaler.product.model.FakeStoreUser;
import com.scaler.product.model.Name;
import com.scaler.product.services.IFakeStoreUserService;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class FakeStoreUserService implements IFakeStoreUserService {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Override
    public FakeStoreUser add(FakeStoreUser user) {
        FakeStoreUserDto userDto = from(user);
        ResponseEntity<FakeStoreUserCreatedResponseDto> responseEntity = this.requestForEntity("https://fakestoreapi.com/users",
                HttpMethod.POST, userDto, FakeStoreUserCreatedResponseDto.class);
        if (!responseEntity.hasBody()) {
            throw new RuntimeException("Exception in response");
        }
        FakeStoreUserCreatedResponseDto response = Objects.requireNonNull(responseEntity.getBody());
        FakeStoreUser result = from(userDto);
        result.setId(response.getId());
        return result;
    }

    @Override
    public FakeStoreUser update(FakeStoreUser user, Long userId) {
        FakeStoreUserDto userDto = from(user);
        userDto.setId(userId);
        ResponseEntity<FakeStoreUserDto> responseEntity = this.requestForEntity("https://fakestoreapi.com/users/{id}",
                HttpMethod.PUT, userDto, FakeStoreUserDto.class, userId);
        if (!responseEntity.hasBody()) {
            throw new RuntimeException("Exception in response");
        }
        return from(Objects.requireNonNull(responseEntity.getBody()));
    }

    private <T> ResponseEntity<T> requestForEntity(String url, HttpMethod method, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, method, requestCallback, responseExtractor, uriVariables);
    }

    private FakeStoreUserDto from(FakeStoreUser user) {
        FakeStoreUserDto fakeStoreUserDto = new FakeStoreUserDto();
        fakeStoreUserDto.setUsername(user.getUsername());
        fakeStoreUserDto.setPassword(user.getPassword());
        fakeStoreUserDto.setEmail(user.getEmail());
        if (user.getAddress() != null) {
            FakeStoreUserNameDto name = new FakeStoreUserNameDto();
            name.setFirstname(user.getName().getFirstname());
            name.setLastname(user.getName().getLastname());
            fakeStoreUserDto.setName(name);
        }
        if (user.getName() != null) {
            FakeStoreUserAddressDto address = new FakeStoreUserAddressDto();
            address.setCity(user.getAddress().getCity());
            address.setStreet(user.getAddress().getStreet());
            address.setNumber(user.getAddress().getNumber());
            fakeStoreUserDto.setAddress(address);
        }
        return fakeStoreUserDto;
    }


    private FakeStoreUser from(FakeStoreUserDto fakeStoreUserDto) {
        FakeStoreUser user = new FakeStoreUser();

        user.setUsername(fakeStoreUserDto.getUsername());
        user.setPassword(fakeStoreUserDto.getPassword());
        user.setEmail(fakeStoreUserDto.getEmail());
        if (fakeStoreUserDto.getAddress() != null) {
            Name name = new Name();
            name.setFirstname(fakeStoreUserDto.getName().getFirstname());
            name.setLastname(fakeStoreUserDto.getName().getLastname());
            user.setName(name);
        }

        if (fakeStoreUserDto.getName() != null) {
            Address address = new Address();
            address.setCity(fakeStoreUserDto.getAddress().getCity());
            address.setStreet(fakeStoreUserDto.getAddress().getStreet());
            address.setNumber(fakeStoreUserDto.getAddress().getNumber());
            user.setAddress(address);
        }

        return user;
    }
}
