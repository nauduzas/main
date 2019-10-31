package com.javaguru.shoppinglist.Service.Validation;

import com.javaguru.shoppinglist.Domain.Product;
import org.springframework.stereotype.Component;

@Component
public class DiscountValidationRule implements ProductValidationRule {
    public final static double minDiscount = 0;
    public final static double maxDiscount = 100;

    @Override
    public void validate(Product product) {

        if (product.getDiscount() < minDiscount || product.getDiscount() > maxDiscount) {
            throw new ProductValidationException("Incorrect discount");
        }


    }
}
