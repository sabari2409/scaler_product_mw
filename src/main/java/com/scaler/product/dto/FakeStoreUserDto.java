package com.scaler.product.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreUserDto {
    private Long id;
    private String email;
    private String password;
    private String username;
    private FakeStoreUserNameDto name;
    private FakeStoreUserAddressDto address;
}
