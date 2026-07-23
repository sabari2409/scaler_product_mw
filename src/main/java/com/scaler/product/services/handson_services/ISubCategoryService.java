package com.scaler.product.services.handson_services;

import com.scaler.product.dto.handson_dto.SubCategoryReqDTO;
import com.scaler.product.model.handson_model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ISubCategoryService {

    Optional<SubCategory> findByScName(String name);

    SubCategory create(SubCategoryReqDTO subCategory);
}
