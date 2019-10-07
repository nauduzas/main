package com.javaguru.shoppinglist.Domain;

import com.javaguru.shoppinglist.Service.Validation.ProductValidationException;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private String category;
    private String description;

    private double discount;

//    void discount() {
//        if (discount == 100) {
//            System.out.println("Error");
//        }
//
//    }


    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
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

    public void setName(String name) throws ProductValidationException {

//        if (name.length() < 3|| name.length()>32) {
//        throw new ProductValidationException(" Name must be not shorter then 3 and not longer then 32 characters ");
//        }


        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) throws ProductValidationException {
//        if (price.equals(0)){
////            throw  new ProductValidationException("wrong");
////
////        }
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return discount == product.discount &&
                Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                Objects.equals(category, product.category) &&
                Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, price, category, description, discount);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", discount=" + discount +
                '}';
    }
}