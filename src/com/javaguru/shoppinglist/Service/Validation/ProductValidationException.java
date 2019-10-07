package com.javaguru.shoppinglist.Service.Validation;

public class ProductValidationException extends RuntimeException {


    private ProductValidationException(String message) {
        super(message);
    }
}
