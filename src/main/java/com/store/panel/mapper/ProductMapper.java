package com.store.panel.mapper;

import com.store.panel.dto.ProductDTO;
import com.store.panel.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDto(Product entity);
    Product toEntity(ProductDTO dto);
}
