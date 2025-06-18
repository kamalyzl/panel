package com.store.panel.service.interfaces;

import com.store.panel.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product save(Product product);
}
