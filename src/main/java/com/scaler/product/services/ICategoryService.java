package com.scaler.product.services;

import com.scaler.product.dto.CategoryDTO;
import com.scaler.product.dto.CategoryReqDTO;

public interface ICategoryService {

    CategoryDTO create(CategoryReqDTO reqDTO);
}
