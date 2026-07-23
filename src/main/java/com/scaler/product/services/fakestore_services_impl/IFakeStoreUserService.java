package com.scaler.product.services.fakestore_services_impl;


import com.scaler.product.model.fakestore_model.FakeStoreUser;

public interface IFakeStoreUserService {
    FakeStoreUser add(FakeStoreUser user);

    FakeStoreUser update(FakeStoreUser user,Long userId);
}
