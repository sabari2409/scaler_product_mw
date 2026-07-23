package com.scaler.product.services.fakestore_services_impl;

import com.scaler.product.model.fakestore_model.FakeStoreCategory;

import java.util.List;

public interface IFakeStoreCategoryService {

    List<FakeStoreCategory> getCategories();
}

