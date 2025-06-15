package com.store.management.service;

import com.store.management.model.entity.Product;
import com.store.management.repository.ProductRepository;
import com.store.management.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    public ProductServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddProduct() {
        Product input = Product.builder()
                .name("Monitor")
                .description("4K Display")
                .price(BigDecimal.valueOf(3434))
                .quantity(2)
                .build();

        when(productRepository.save(input)).thenReturn(input);

        Product result = productService.addProduct(input);

        assertEquals("Monitor", result.getName());
        assertEquals("4K Display", result.getDescription());
        verify(productRepository, times(1)).save(input);
    }
}
