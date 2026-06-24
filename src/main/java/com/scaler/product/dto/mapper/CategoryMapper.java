package com.scaler.product.dto.mapper;

import com.scaler.product.dto.CategoryDTO;
import com.scaler.product.model.Category;
import com.scaler.product.model.Product;

import java.util.List;
import java.util.UUID;

public class CategoryMapper implements IMapper<Category, CategoryDTO> {
    @Override
    public CategoryDTO toDTO(Category entity) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setUuid(UUID.randomUUID());
        categoryDTO.setName(entity.getName());
        categoryDTO.setDescription(entity.getDescription());
        return categoryDTO;
    }

    @Override
    public Category toEntity(CategoryDTO dto) {
        return null;
    }

    @Override
    public List<CategoryDTO> toDTOList(List<Category> entityList) {
        return List.of();
    }
}
