package com.store.management.service.impl;

import com.store.management.exception.ProductNotFoundException;
import com.store.management.model.entity.Product;
import com.store.management.repository.ProductRepository;
import com.store.management.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(Product product) {
        logger.info("Adding new product: {}", product.getName());
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product updateProductPrice(Long id, BigDecimal newPrice) {
        logger.info("Updating price for product with id {}: new price = {}", id, newPrice);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        product.setPrice(newPrice);
        return productRepository.save(product);
    }
}
