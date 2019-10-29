package com.javaguru.shoppinglist.Service.Validation;

import com.javaguru.shoppinglist.Domain.Product;
import com.javaguru.shoppinglist.Repository.ProductInMemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductUniqueNameValidationRule implements ProductValidationRule {

    private final ProductInMemoryRepository repository;

    @Autowired
    public ProductUniqueNameValidationRule(ProductInMemoryRepository product) {

        this.repository = product;
    }

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (repository.existByName(product.getName())) {
            throw new ProductValidationException("Product name must be umiq");
        }

    }


}
