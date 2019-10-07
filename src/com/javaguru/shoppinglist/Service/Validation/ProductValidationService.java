package com.javaguru.shoppinglist.Service.Validation;

import com.javaguru.shoppinglist.Domain.Product;

import java.util.HashSet;
import java.util.Set;

public class ProductValidationService {
    private Set<ProductValidationRule> validationRules = new HashSet<>();

    public ProductValidationService() {
        validationRules.add(new ProductNameValidationRule());

    }

    public void validate(Product product) {
        validationRules.forEach(s -> s.validate(product));
    }


}
