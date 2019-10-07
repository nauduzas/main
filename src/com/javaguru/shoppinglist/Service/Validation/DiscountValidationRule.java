package com.javaguru.shoppinglist.Service.Validation;

import com.javaguru.shoppinglist.Domain.Product;

public class DiscountValidationRule implements ProductValidationRule {


    @Override
    public void validate(Product discount) {
        {
            if (discount.equals(0) || discount.equals(100)) {
                System.out.println("Discount must be not less than 0 and not more than 100");
            }
        }
    }
}
