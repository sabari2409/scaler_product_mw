package com.scaler.product.dto.mapper;

import com.scaler.product.dto.handson_dto.ProductResDTO;
import com.scaler.product.model.handson_model.Product;

import java.util.List;

public class ProductMapper implements IMapper<Product, ProductResDTO> {
    @Override
    public ProductResDTO toDTO(Product entity) {
        ProductResDTO productResDTO = new ProductResDTO();
        productResDTO.setName(entity.getPName());
        productResDTO.setDescription(entity.getPDescription());
        productResDTO.setUuid(entity.getUuid());
        productResDTO.setPrice(entity.getPrice());
        return productResDTO;
    }

    @Override
    public Product toEntity(ProductResDTO dto) {
        return null;
    }

    @Override
    public List<ProductResDTO> toDTOList(List<Product> entityList) {
        return List.of();
    }
}
