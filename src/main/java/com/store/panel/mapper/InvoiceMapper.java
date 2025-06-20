package com.store.panel.mapper;

import com.store.panel.dto.InvoiceDTO;
import com.store.panel.dto.InvoiceDetailDTO;
import com.store.panel.entity.Invoice;
import com.store.panel.entity.InvoiceDetail;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InvoiceMapper {

    public InvoiceDTO toDto(Invoice invoice) {
        return InvoiceDTO.builder()
                .id(invoice.getId())
                .invoiceDate(invoice.getInvoiceDate())
                .totalAmount(invoice.getTotalAmount())
                .customerId(invoice.getCustomer().getId())
                .customerName(invoice.getCustomer().getName() + " " + invoice.getCustomer().getLastname())
                .details(toDetailDtoList(invoice.getDetails()))
                .build();
    }

    public Invoice toEntity(InvoiceDTO dto) {
        Invoice invoice = new Invoice();
        invoice.setInvoiceDate(java.time.LocalDate.now());
        invoice.setDetails(toDetailEntityList(dto.getDetails()));
        return invoice;
    }

    private List<InvoiceDetailDTO> toDetailDtoList(List<InvoiceDetail> details) {
        return details.stream()
                .map(detail -> InvoiceDetailDTO.builder()
                        .productId(detail.getProduct().getId())
                        .productName(detail.getProduct().getName())
                        .quantity(detail.getQuantity())
                        .price(detail.getPrice())
                        .build())
                .collect(Collectors.toList());
    }

    private List<InvoiceDetail> toDetailEntityList(List<InvoiceDetailDTO> dtos) {
        return dtos.stream()
                .map(dto -> InvoiceDetail.builder()
                        .product(com.store.panel.entity.Product.builder().id(dto.getProductId()).build())
                        .quantity(dto.getQuantity())
                        .price(dto.getPrice())
                        .build())
                .collect(Collectors.toList());
    }
}
