package com.scaler.product.dto.mapper;

import com.scaler.product.dto.CategoryDTO;
import com.scaler.product.dto.ProductDTO;
import com.scaler.product.model.Product;

import java.util.List;
import java.util.UUID;

public class ProductMapper implements IMapper<Product, ProductDTO> {

    @Override
    public ProductDTO toDTO(Product entity) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setTitle(entity.getTitle());
        productDTO.setPrice(entity.getPrice());
        productDTO.setDescription(entity.getDescription());
        productDTO.setImage(entity.getImage());
        productDTO.setCategory(entity.getCategory());
        productDTO.setRating(entity.getRating());
        return productDTO;
    }

    @Override
    public Product toEntity(ProductDTO dto) {
        return null;
    }

    @Override
    public List<ProductDTO> toDTOList(List<Product> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }


}
