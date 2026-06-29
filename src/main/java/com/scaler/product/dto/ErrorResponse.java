package com.scaler.product.dto;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@AllArgsConstructor
public class ErrorResponse {
    private HttpStatus httpStatus;
    private String errMsg;
}
