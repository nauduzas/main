package com.javaguru.shoppinglist.Service.Validation;

import com.javaguru.shoppinglist.Domain.Product;
import org.springframework.stereotype.Component;

@Component
public class DiscountValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {

        if (product.getDiscount() == 0) {
            throw new ProductValidationException("Incorrect discount");

        }
        {
            if (product.getDiscount() == 0 || product.getDiscount() == 100) {
                System.out.println("Discount must be not less than 0 and not more than 100");
            }
            throw new ProductValidationException("Incorrect discount");
        }
    }
}
