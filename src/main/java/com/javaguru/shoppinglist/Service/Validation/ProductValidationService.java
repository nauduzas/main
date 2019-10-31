package com.javaguru.shoppinglist.Service.Validation;

import com.javaguru.shoppinglist.Domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ProductValidationService {
    private final Set<ProductValidationRule> validationRules;

    @Autowired
    public ProductValidationService(Set<ProductValidationRule> validationRules) {
        this.validationRules = validationRules;

    }

    public void validate(Product product) {
        validationRules.forEach(s -> s.validate(product));
    }


}

