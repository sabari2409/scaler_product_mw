package com.scaler.product.services.handson_services.Impl;

import com.scaler.product.dto.handson_dto.ProductReqDto;
import com.scaler.product.dto.handson_dto.ProductResDTO;
import com.scaler.product.dto.mapper.ProductMapper;
import com.scaler.product.exception.CategoryException;
import com.scaler.product.exception.ProductException;
import com.scaler.product.exception.SubCategoryException;
import com.scaler.product.model.handson_model.Category;
import com.scaler.product.model.handson_model.Product;
import com.scaler.product.model.handson_model.SubCategory;
import com.scaler.product.repo.ProductRepository;
import com.scaler.product.services.handson_services.ICategoryService;
import com.scaler.product.services.handson_services.IProductService;
import com.scaler.product.services.handson_services.ISubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ISubCategoryService subCategoryService;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductResDTO create(ProductReqDto reqDto) {
        // TODO: check category exist in DB
        Optional<Category> category = this.categoryService.findByName(reqDto.getCategory());
        // TODO check subcategory exist in DB
        Assert.notNull(category, "Category is not present for the product");
        if (category.isEmpty()) throw new CategoryException("Category is not present for the product");
        Category categoryDetails = category.get();
        Optional<SubCategory> subCategory = this.subCategoryService.findByScName(reqDto.getSubCategory());
        if (subCategory.isEmpty()) throw new SubCategoryException("Subcategory not present");
        SubCategory subCategoryDetails = subCategory.get();

        // TODO insert product in DB
        Product product = new Product();
        product.setCategory(categoryDetails);
        product.setStatus(true);
        product.setPrice(reqDto.getPrice());
        product.setPName(reqDto.getName());
        product.setPDescription(reqDto.getDescription());
        product.setSubCategory(subCategoryDetails);
        product.setUuid(UUID.randomUUID());
        product.setCreateDateTime(LocalDateTime.now());
        product.setUpdatedDateTime(LocalDateTime.now());
        Product productDetails = this.productRepository.save(product);
        return new ProductMapper().toDTO(productDetails);
    }

    @Override
    public Page<Product> findByCategoryIdAndSubCategoryId(Long categoryId, Long subCategoryId, Pageable pageable) {
        return this.productRepository.findByCategoryIdAndSubCategoryId(categoryId, subCategoryId, pageable);
    }

    @Override
    public Page<Product> findBypName(String query, Pageable pageable) {
        return this.productRepository.findBypName(query, pageable);
    }
}
