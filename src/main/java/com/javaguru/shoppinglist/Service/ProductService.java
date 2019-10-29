package com.javaguru.shoppinglist.Service;

import com.javaguru.shoppinglist.Domain.Product;
import com.javaguru.shoppinglist.Repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.Service.Validation.ProductValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
@Component
public class ProductService {

    private final ProductInMemoryRepository repository;
    private final ProductValidationService validationService;


    @Autowired
    public ProductService(ProductInMemoryRepository repository,
                          ProductValidationService validationService){
        this.repository=repository;
        this.validationService = validationService;
    }

    public Long createProduct(Product product) {
        validationService.validate(product);
        Product createdProduct = repository.save(product);
        return createdProduct.getId();

    }

    public Product findProductById(Long id) {
        return repository.findProductById(id)
             .orElseThrow(() -> new NoSuchElementException("Task not found, id: " + id));
    }


}
