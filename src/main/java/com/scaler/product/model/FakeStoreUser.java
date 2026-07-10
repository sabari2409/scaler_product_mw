package com.scaler.product.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreUser {
    private Long id;
    private String email;
    private String password;
    private String username;
    private Name name;
    private Address address;
}
