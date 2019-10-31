package com.javaguru.shoppinglist.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.javaguru.shoppinglist.Domain.Product;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;

@Component
public class ProductInMemoryRepository {

    private Long productIdSequence = 0L;
    private Map<Long, Product> productRepository = new HashMap<>();


    public Product save(Product product) {
        product.setId(productIdSequence++);
        productRepository.put(product.getId(), product);
        return product;
    }

    public Optional<Product> findProductById(Long id) {

        return Optional.ofNullable(productRepository.get(id));
    }

    public boolean existByName(String name) {
        return productRepository.values().stream()
                .anyMatch(product -> product.getName().equalsIgnoreCase(name));
    }

    public Optional<Product> findProductByName(String name) {
        return productRepository.values().stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .findFirst();
    }

}
