package com.store.panel.service.interfaces;

import com.store.panel.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    Product createProduct(Product product);
    Optional<Product> updateProduct(Long id, Product product);
    boolean deleteProduct(Long id);
}
