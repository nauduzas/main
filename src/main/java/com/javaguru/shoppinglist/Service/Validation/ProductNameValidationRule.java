package com.javaguru.shoppinglist.Service.Validation;

import com.javaguru.shoppinglist.Domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductNameValidationRule implements ProductValidationRule {

    public final static int minNameLength = 3;
    public final static int maxNameLength = 32;

    @Override
    public void validate(Product product) {
        checkNotNull(product);

        if (product.getName() == null) {
            throw new ProductValidationException("Product name must be not null 1");
        }
        if (product.getName().length() < minNameLength || product.getName().length() > maxNameLength) {
            throw new ProductValidationException("Product length must be not less than 3 or not more than 32 symbol");
        }
    }
}
