package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.Consloe.ConsoleUI;
import com.javaguru.shoppinglist.Domain.Product;

import java.util.HashMap;
import java.util.Map;

public class Application {


    public static void main(String[] args) {
        Map<Long, Product> productRepository = new HashMap<>();
        Long productIdSequence = 0L;

        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.execute();

    }
}
