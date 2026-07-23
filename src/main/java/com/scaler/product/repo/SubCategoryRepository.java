package com.scaler.product.repo;

import com.scaler.product.model.handson_model.Category;
import com.scaler.product.model.handson_model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    Optional<SubCategory> findByScName(String name);
}
