package com.scaler.product.dto;

import com.scaler.product.model.Address;
import com.scaler.product.model.Name;
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
