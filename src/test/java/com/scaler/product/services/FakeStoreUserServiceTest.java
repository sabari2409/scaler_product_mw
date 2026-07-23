package com.scaler.product.services;


import com.scaler.product.dto.falestore_dto.FakeStoreUserAddressDto;
import com.scaler.product.dto.falestore_dto.FakeStoreUserCreatedResponseDto;
import com.scaler.product.dto.falestore_dto.FakeStoreUserDto;
import com.scaler.product.dto.falestore_dto.FakeStoreUserNameDto;
import com.scaler.product.model.fakestore_model.Address;
import com.scaler.product.model.fakestore_model.FakeStoreUser;
import com.scaler.product.model.fakestore_model.Name;
import com.scaler.product.services.fakestore_services_impl.FakeStoreUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FakeStoreUserServiceTest {

    @Autowired
    private FakeStoreUserService userService;

    @MockitoBean
    private RestTemplateBuilder restTemplateBuilder;

    @MockitoBean
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        when(restTemplateBuilder.build()).thenReturn(restTemplate);
    }

    @Test
    void testAddUser() {
        FakeStoreUser user = new FakeStoreUser();
        user.setUsername("john_doe");
        user.setPassword("password123");
        user.setEmail("john@example.com");
        Name name = new Name();
        name.setFirstname("John");
        name.setLastname("Doe");
        user.setName(name);
        Address address = new Address();
        address.setCity("Springfield");
        address.setStreet("Main St");
        address.setNumber(123L);
        user.setAddress(address);

        FakeStoreUserDto requestDto = new FakeStoreUserDto();
        requestDto.setUsername("john_doe");
        requestDto.setPassword("password123");
        requestDto.setEmail("john@example.com");
        FakeStoreUserNameDto fakeStoreUserNameDto = new FakeStoreUserNameDto();
        fakeStoreUserNameDto.setFirstname("John");
        fakeStoreUserNameDto.setLastname("Doe");
        FakeStoreUserAddressDto fakeStoreUserAddressDto = new FakeStoreUserAddressDto();
        fakeStoreUserAddressDto.setCity("Springfield");
        fakeStoreUserAddressDto.setStreet("Main St");
        fakeStoreUserAddressDto.setNumber(123L);
        requestDto.setName(fakeStoreUserNameDto);
        requestDto.setAddress(fakeStoreUserAddressDto);

        FakeStoreUserCreatedResponseDto responseDto = new FakeStoreUserCreatedResponseDto();
        responseDto.setId(1L);

        when(restTemplate.execute(eq("https://fakestoreapi.com/users"), eq(HttpMethod.POST), any(), any()))
                .thenReturn(ResponseEntity.ok(responseDto));

        FakeStoreUser result = userService.add(user);

        verify(restTemplate).execute(eq("https://fakestoreapi.com/users"), eq(HttpMethod.POST), any(), any());
        assertEquals(1L, result.getId());
    }

    @Test
    void testUpdateUser() {
        FakeStoreUser user = new FakeStoreUser();
        user.setUsername("john_doe_updated");
        user.setPassword("newpassword123");
        user.setEmail("john_updated@example.com");
        Name name = new Name();
        name.setFirstname("John");
        name.setLastname("Doe");
        user.setName(name);
        Address address = new Address();
        address.setCity("Springfield");
        address.setStreet("Main St");
        address.setNumber(123L);
        user.setAddress(address);

        FakeStoreUserNameDto fakeStoreUserNameDto = new FakeStoreUserNameDto();
        fakeStoreUserNameDto.setFirstname("John");
        fakeStoreUserNameDto.setLastname("Doe");
        FakeStoreUserAddressDto fakeStoreUserAddressDto = new FakeStoreUserAddressDto();
        fakeStoreUserAddressDto.setCity("Shelbyville");
        fakeStoreUserAddressDto.setStreet("Elm St");
        fakeStoreUserAddressDto.setNumber(456L);
        FakeStoreUserDto responseDto = new FakeStoreUserDto();
        responseDto.setUsername("john_doe_updated");
        responseDto.setPassword("newpassword123");
        responseDto.setEmail("john_updated@example.com");
        responseDto.setName(fakeStoreUserNameDto);
        responseDto.setAddress(fakeStoreUserAddressDto);

        when(restTemplate.execute(any(String.class), any(HttpMethod.class), any(), any(), Optional.ofNullable(any())))
                .thenReturn(ResponseEntity.ok(responseDto));

        FakeStoreUser result = userService.update(user, 1L);

        verify(restTemplate).execute(any(String.class), any(HttpMethod.class), any(), any(), Optional.ofNullable(any()));
        assertEquals("john_doe_updated", result.getUsername());
        assertEquals("john_updated@example.com", result.getEmail());
        assertEquals("Shelbyville", result.getAddress().getCity());
    }
}
