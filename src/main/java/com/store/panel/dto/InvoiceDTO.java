package com.store.panel.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceDTO {
    private Long id;
    private LocalDate invoiceDate;
    private BigDecimal totalAmount;
    private Long customerId;
    private String customerName;
    private List<InvoiceDetailDTO> details;
}
