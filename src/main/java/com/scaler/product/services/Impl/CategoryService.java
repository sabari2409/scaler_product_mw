package com.scaler.product.services.Impl;

import com.scaler.product.dao.CategoryRepository;
import com.scaler.product.dto.CategoryDTO;
import com.scaler.product.dto.CategoryReqDTO;
import com.scaler.product.dto.mapper.CategoryMapper;
import com.scaler.product.model.Category;
import com.scaler.product.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDTO create(CategoryReqDTO reqDTO) {
        Category category = new Category();
        category.setName(reqDTO.getName());
        category.setDescription(reqDTO.getDescription());
        category.setCreatedDate(new Date());
        category.setUpdatedDate(new Date());
        category.setIsActive(true);
        Category category1 = this.categoryRepository.save(category);
        return this.toDTO(category1);
    }

    private CategoryDTO toDTO(Category category) {
        CategoryMapper mapper = new CategoryMapper();
        return mapper.toDTO(category);
    }
}
