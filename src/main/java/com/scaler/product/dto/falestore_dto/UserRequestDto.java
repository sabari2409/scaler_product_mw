package com.scaler.product.dto.falestore_dto;

import com.scaler.product.model.fakestore_model.Address;
import com.scaler.product.model.fakestore_model.Name;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequestDto {
    private String email;
    private String password;
    private String username;
    private Name name;
    private Address address;
}
