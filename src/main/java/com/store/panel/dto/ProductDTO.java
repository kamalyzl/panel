package com.store.panel.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be at most 100 characters")
    private String name;

    @Size(max = 255, message = "Description must be at most 255 characters")
    private String description;

    @NotNull(message = "Total quantity is required")
    @PositiveOrZero(message = "Total quantity must be zero or more")
    private Integer totalQuantity;

    @NotNull(message = "Available quantity is required")
    @PositiveOrZero(message = "Available quantity must be zero or more")
    private Integer availableQuantity;

    @NotBlank(message = "Category is required")
    @Size(max = 100, message = "Category must be at most 100 characters")
    private String category;

    @NotNull(message = "Price is required")
    @PositiveOrZero(message = "Price must be zero or more")
    private Double price;
}
