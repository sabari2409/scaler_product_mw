package com.scaler.product.repo;

import com.scaler.product.model.handson_model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findBypName(String query, Pageable pageable);

    Page<Product> findByCategoryIdAndSubCategoryId(
            Long categoryId,
            Long subCategoryId,
            Pageable pageable
    );
}
