package com.javaguru.shoppinglist.Service.Validation;

import com.javaguru.shoppinglist.Domain.Product;
import com.javaguru.shoppinglist.Repository.ProductInMemoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductUniqueNameValidationRuleTest {

    @Mock
    private ProductInMemoryRepository productInMemoryRepository;

    @Spy
    @InjectMocks
    private ProductUniqueNameValidationRule victim;

    private Product product = product();

    @Test
    public void shouldTrowException() {
        when(productInMemoryRepository.existByName(product.getName()))
                .thenReturn(true);

        assertThatThrownBy(() -> victim.validate(product))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage("Product name must be unique");

        verify(victim).checkNotNull(product);

    }

    @Test
    public void shouldValidateSuccess() {
        when(productInMemoryRepository.existByName(product.getName()))
                .thenReturn(false);

        victim.validate(product);

        verify(victim).checkNotNull(product);
    }
        private  Product product(){
        Product product = new Product();
        product.setId(123L);
        product.setDescription("TEST_DESCRIPTION");
        product.setName("TEST_NAME");
        return product;
        }

}