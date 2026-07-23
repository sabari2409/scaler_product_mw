package com.scaler.product.services.handson_services.Impl;

import com.scaler.product.dto.handson_dto.SubCategoryReqDTO;
import com.scaler.product.exception.CategoryException;
import com.scaler.product.model.handson_model.Category;
import com.scaler.product.model.handson_model.SubCategory;
import com.scaler.product.repo.SubCategoryRepository;
import com.scaler.product.services.handson_services.ICategoryService;
import com.scaler.product.services.handson_services.ISubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class SubCategoryService implements ISubCategoryService {


    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Override
    public Optional<SubCategory> findByScName(String name) {
        return this.subCategoryRepository.findByScName(name);
    }

    @Override
    public SubCategory create(SubCategoryReqDTO subCategory) {
        // TODO: find category details by category name
        Optional<Category> category = this.categoryService.findByName(subCategory.getCategoryName());
        if (category.isEmpty()) throw new CategoryException("Category details not present while creating subcategory");
        SubCategory subCategory1 = new SubCategory();
        subCategory1.setUuid(UUID.randomUUID());
        subCategory1.setScName(subCategory.getName());
        subCategory1.setScDescription(subCategory.getDescription());
        subCategory1.setCreateDateTime(LocalDateTime.now());
        subCategory1.setUpdatedDateTime(LocalDateTime.now());
        subCategory1.setCategory(category.get());
        return this.subCategoryRepository.save(subCategory1);
    }
}
