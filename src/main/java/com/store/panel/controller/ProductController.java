package com.store.panel.controller;

import com.store.panel.dto.ProductDTO;
import com.store.panel.entity.Product;
import com.store.panel.mapper.ProductMapper;
import com.store.panel.service.interfaces.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
@Validated
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @GetMapping
    public List<ProductDTO> getAll() {
        return productService.findAll()
                .stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<ProductDTO> create(@Valid @RequestBody ProductDTO dto) {
        Product saved = productService.save(productMapper.toEntity(dto));
        return ResponseEntity.ok(productMapper.toDto(saved));
    }
}
