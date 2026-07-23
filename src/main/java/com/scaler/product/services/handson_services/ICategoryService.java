package com.scaler.product.services.handson_services;

import com.scaler.product.dto.handson_dto.CategoryReqDTO;
import com.scaler.product.dto.handson_dto.ProductReqDto;
import com.scaler.product.model.handson_model.Category;
import com.scaler.product.model.handson_model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ICategoryService {

    Optional<Category> findByName(String name);

    Category create(CategoryReqDTO reqDTO);

}
