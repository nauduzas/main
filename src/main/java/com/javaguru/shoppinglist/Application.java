package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.Consloe.ConsoleUI;
import com.javaguru.shoppinglist.Domain.Product;
import com.javaguru.shoppinglist.Repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.Service.ProductService;
import com.javaguru.shoppinglist.Service.Validation.ProductNameValidationRule;
import com.javaguru.shoppinglist.Service.Validation.ProductUniqueNameValidationRule;
import com.javaguru.shoppinglist.Service.Validation.ProductValidationRule;
import com.javaguru.shoppinglist.Service.Validation.ProductValidationService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Application {


    public static void main(String[] args) {
        ProductInMemoryRepository repository = new ProductInMemoryRepository();

        ProductValidationRule productNameValidationRule = new ProductNameValidationRule();
        ProductValidationRule productUniqueNameValidationRule = new ProductUniqueNameValidationRule(repository);
        Set<ProductValidationRule> rules = new HashSet<>();
        rules.add(productNameValidationRule);
        rules.add(productUniqueNameValidationRule);

        ProductValidationService validationService = new ProductValidationService(rules);

        ProductService productService = new ProductService(repository, validationService);

        ConsoleUI consoleUI = new ConsoleUI(productService);
        consoleUI.execute();

    }
}
