package com.scaler.product.dto.handson_dto;

import com.scaler.product.model.handson_model.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Setter
@Getter
public class SearchRespDTO {
    Page<Product> searchResults;
}
