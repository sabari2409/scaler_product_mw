package com.scaler.product.services;

import com.scaler.product.dto.ProductDTO;
import com.scaler.product.model.Product;

import java.util.List;

public interface IProductService {

    ProductDTO getProductById(int pId);

    List<ProductDTO> getAllProducts();

    Product create(Product product);

    ProductDTO updateProduct(int id, ProductDTO product);
}
