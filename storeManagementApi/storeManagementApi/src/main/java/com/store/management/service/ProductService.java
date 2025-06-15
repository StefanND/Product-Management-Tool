package com.store.management.service;

import com.store.management.model.entity.Product;

import java.math.BigDecimal;
import java.util.Optional;

public interface ProductService {

    Product addProduct(Product product);

    Optional<Product> getProductById(Long id);

    Product updateProductPrice(Long id, BigDecimal newPrice);
}
