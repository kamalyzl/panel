package com.store.panel.mapper;

import com.store.panel.dto.InvoiceDTO;
import com.store.panel.entity.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    InvoiceDTO toDto(Invoice entity);
    Invoice toEntity(InvoiceDTO dto);
}