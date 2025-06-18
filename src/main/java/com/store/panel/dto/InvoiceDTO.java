package com.store.panel.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public class InvoiceDTO {
    private Long id;

    @NotNull
    private Long customerId;

    @NotEmpty
    private List<Long> productIds;

    private LocalDateTime createdAt;
}
