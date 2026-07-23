package com.scaler.product.services.handson_services;

import com.scaler.product.dto.handson_dto.ProductReqDto;
import com.scaler.product.dto.handson_dto.ProductResDTO;
import com.scaler.product.model.handson_model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IProductService {

    ProductResDTO create(ProductReqDto reqDto);

    Page<Product> findByCategoryIdAndSubCategoryId(Long CategoryId, Long subCategoryId, Pageable pageable);

    Page<Product> findBypName(String query, Pageable pageable);

}
