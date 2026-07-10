package com.scaler.product.services;


import com.scaler.product.model.FakeStoreUser;

public interface IFakeStoreUserService {
    FakeStoreUser add(FakeStoreUser user);

    FakeStoreUser update(FakeStoreUser user,Long userId);
}
