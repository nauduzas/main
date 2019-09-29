package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private String name;

    void nameRules() {
        if (name.length() < 3 && name.length() > 32) {
            System.out.println("Name must be not shorter then 3 and not longer then 32 characters ");
        }
    }

    private BigDecimal price;

    void priceRules(BigDecimal price) {
        if (price.equals(0)) {
            System.out.println("Incorect price");
        }
    }

    private String category;
    private String description;

    private int discount;

    void discount() {
        if (discount == 100) {
            System.out.println("Error");
        }

    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
