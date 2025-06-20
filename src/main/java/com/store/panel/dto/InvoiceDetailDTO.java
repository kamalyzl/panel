package com.store.panel.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceDetailDTO {
    private Long productId;
    private String productName;
    private Integer quantity;
    private BigDecimal price;
}
