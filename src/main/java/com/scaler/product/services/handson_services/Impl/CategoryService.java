package com.scaler.product.services.handson_services.Impl;

import com.scaler.product.dto.handson_dto.CategoryReqDTO;
import com.scaler.product.model.handson_model.Category;
import com.scaler.product.repo.CategoryRepository;
import com.scaler.product.services.handson_services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService implements ICategoryService {


    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Optional<Category> findByName(String name) {
        return this.categoryRepository.findBycName(name);
    }

    @Override
    public Category create(CategoryReqDTO reqDTO) {
        Category category = new Category();
        category.setCName(reqDTO.getName());
        category.setCDescription(reqDTO.getDescription());
        category.setStatus(true);
        category.setCreateDateTime(LocalDateTime.now());
        category.setUpdatedDateTime(LocalDateTime.now());
        category.setUuid(UUID.randomUUID());
        Category category1 = this.categoryRepository.save(category);
        return category1;
    }
}
