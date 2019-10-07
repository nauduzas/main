package com.javaguru.shoppinglist.Repository;

import java.util.HashMap;
import java.util.Map;

import com.javaguru.shoppinglist.Domain.Product;

public class ProductInMemoryRepository {

    private Long productIdSequence;
    private Map<Long, Product> productRepository;


    public Product save(Product product) {

        productRepository.put(productIdSequence, product);
        product.setId(productIdSequence++);
        return product;
    }

    public Product findProductById(Long id) {
        return productRepository.get(productIdSequence);
    }

}
