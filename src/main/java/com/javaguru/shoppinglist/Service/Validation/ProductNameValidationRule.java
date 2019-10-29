package com.javaguru.shoppinglist.Service.Validation;

import com.javaguru.shoppinglist.Domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductNameValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
       checkNotNull(product);

        if (product.getName()==null ) {
            throw new ProductValidationException("Product name must be not null 1" );
        }
    }
}
