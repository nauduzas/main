package com.javaguru.shoppinglist.Service;

import com.javaguru.shoppinglist.Domain.Product;
import com.javaguru.shoppinglist.Repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.Service.Validation.ProductValidationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;
import java.util.NoSuchElementException;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductInMemoryRepository repository;

    @Mock
    private ProductValidationService validationService;


    @Captor
    private ArgumentCaptor<Product> productCaptor;

    private ProductService victim;

    @Before
    public  void  setUp(){
        victim = new ProductService(repository,validationService);
    }


    @Test
    public void createProduct() {
        Product product = product();
        when(repository.save(product)).thenReturn(product);

        Long result = victim.createProduct(product);

        verify(validationService).validate(productCaptor.capture());
        Product captorResult = productCaptor.getValue();

        assertThat(captorResult).isEqualTo(product);
        assertThat(product.getId()).isEqualTo(result);
    }

    @Test
    public void findProductById() {
        when(repository.findProductById(1001L)).thenReturn(Optional.ofNullable(product()));

        Product result = victim.findProductById(1001L);

        assertThat(result).isEqualTo(product());

    }

    @Test
    public void shouldThrowExceptionProductNotFound(){
        when(repository.findProductById(any())).thenReturn(Optional.empty());

       assertThatThrownBy(()->victim.findProductById(1001L))
               .isInstanceOf(NoSuchElementException.class)
               .hasMessage("Product not found. id 1001 ");


    }

    private  Product product(){
        Product product = new Product();
        product.setName("TEST_NAME");
        product.setDescription("TEST_DESCRIPTION");
        product.setId(1001L);
        return product;
    }
}