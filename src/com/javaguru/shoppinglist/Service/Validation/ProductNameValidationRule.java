package com.javaguru.shoppinglist.Service.Validation;

import com.javaguru.shoppinglist.Domain.Product;

public class ProductNameValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        checkNotNull(product);
//        if (product.getName().length() < 3 || product.getName().length() > 32) {
//            throw new ProductValidationException("Product name must be not null 1");
//        }
    }
}
