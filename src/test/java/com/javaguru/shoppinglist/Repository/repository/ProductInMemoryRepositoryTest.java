package com.javaguru.shoppinglist.Repository.repository;

import com.javaguru.shoppinglist.Domain.Product;
import com.javaguru.shoppinglist.Repository.ProductInMemoryRepository;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductInMemoryRepositoryTest {

    private static final String PRODUCT_NAME = "TEST_NAME";
    private static final String PRODUCT_DESCRIPTION = "TEST_DESCRIPTION";
    private static final long PRODUCT_ID = 0L;

    private ProductInMemoryRepository victim = new ProductInMemoryRepository();

    private Product product = product();

    @Test
    public void save() {
        Product result = victim.save(product);
        assertThat(result).isEqualTo(expectedProduct());
    }

    @Test
    public void findProductById() {
        victim.save(product);
        Optional<Product> result = victim.findProductById(PRODUCT_ID);
        assertThat(result).isNotEmpty();
        assertThat(result).hasValue(expectedProduct());

    }

    @Test
    public void findProductByName() {
        victim.save(product);

        Optional<Product> result = victim.findProductByName(PRODUCT_NAME);
        assertThat(result).isNotEmpty();
        assertThat(result).hasValue(expectedProduct());

    }


    @Test
    public void existByName() {
        victim.save(product);
        boolean result = victim.existByName(PRODUCT_NAME);
        assertThat(result).isTrue();
    }

    private Product expectedProduct(){
        Product product= new Product();
        product.setName(PRODUCT_NAME);
        product.setDescription(PRODUCT_DESCRIPTION);
        product.setId(PRODUCT_ID);
        return product;
    }

    private Product product(){
        Product product=new Product();
        product.setName(PRODUCT_NAME);
        product.setDescription(PRODUCT_DESCRIPTION);
        return product;
    }
}