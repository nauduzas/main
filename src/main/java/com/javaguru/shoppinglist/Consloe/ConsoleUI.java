package com.javaguru.shoppinglist.Consloe;

import com.javaguru.shoppinglist.Service.ProductService;
import com.javaguru.shoppinglist.Service.Validation.ProductValidationException;
import com.javaguru.shoppinglist.Domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

@Component
public class ConsoleUI {
    private ProductService productService;

    public ConsoleUI(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void execute() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Exit");
                int userInput = scanner.nextInt();
                switch (userInput) {
                    case 1:
                        createProduct();
                        break;
                    case 2:
                        findProduct();
                        break;
                    case 3:
                        return;

                }
            } catch (ProductValidationException e) {
                System.err.println(e.getMessage());
                System.out.println("Error");
            }
        }
    }

    private void createProduct() {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter product price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());
        System.out.println("Enter product category");
        String category = scanner.nextLine();
        System.out.println("Enter product description");
        String description = scanner.nextLine();
        System.out.println("Enter product discount");
        Double discount = scanner.nextDouble();

        Product product = new Product();


        product.setName(name);
        Long id = productService.createProduct(product);
        product.setId(id);

        product.setPrice(price);
        product.setCategory(category);
        product.setDescription(description);
        product.setDiscount(discount);


        System.out.println("Result: " + product.getId());
    }

    private void findProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        long id = scanner.nextLong();
        Product product = productService.findProductById(id);
        System.out.println(product);
    }
}
