package com.store.panel.controller;

import com.store.panel.dto.InvoiceDTO;
import com.store.panel.entity.Invoice;
import com.store.panel.mapper.InvoiceMapper;
import com.store.panel.service.interfaces.IInvoiceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/invoices")
@Validated
public class InvoiceController {

    @Autowired
    private IInvoiceService invoiceService;

    @Autowired
    private InvoiceMapper invoiceMapper;

    @GetMapping
    public List<InvoiceDTO> getAll() {
        return invoiceService.findAll()
                .stream()
                .map(invoiceMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<InvoiceDTO> create(@Valid @RequestBody InvoiceDTO dto) {
        Invoice saved = invoiceService.save(invoiceMapper.toEntity(dto));
        return ResponseEntity.ok(invoiceMapper.toDto(saved));
    }
}
