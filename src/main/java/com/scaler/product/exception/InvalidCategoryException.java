package com.scaler.product.exception;

import org.springframework.http.HttpStatus;

public class InvalidCategoryException extends RuntimeException {

    public InvalidCategoryException() {
        super();
    }

    public InvalidCategoryException(String message) {
        super(message);
    }
}
