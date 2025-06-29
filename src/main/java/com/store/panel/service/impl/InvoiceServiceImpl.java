package com.store.panel.service.impl;

import com.store.panel.dto.InvoiceDTO;
import com.store.panel.entity.Customer;
import com.store.panel.entity.Invoice;
import com.store.panel.exception.ResourceNotFoundException;
import com.store.panel.mapper.InvoiceMapper;
import com.store.panel.repository.CustomerRepository;
import com.store.panel.repository.InvoiceRepository;
import com.store.panel.service.interfaces.IInvoiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InvoiceServiceImpl implements IInvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final CustomerRepository customerRepository;
    private final InvoiceMapper invoiceMapper;

    @Override
    public InvoiceDTO createInvoice(InvoiceDTO dto) {
        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        Invoice invoice = invoiceMapper.toEntity(dto);
        invoice.setCustomer(customer);

        if (invoice.getDetails() != null) {
            invoice.getDetails().forEach(detail -> detail.setInvoice(invoice));
        }

        BigDecimal total = invoice.getDetails().stream()
                .map(d -> d.getPrice().multiply(BigDecimal.valueOf(d.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        invoice.setTotalAmount(total);

        Invoice saved = invoiceRepository.save(invoice);
        return invoiceMapper.toDto(saved);
    }

    @Override
    public List<InvoiceDTO> getAllInvoices() {
        return invoiceRepository.findAll().stream()
                .map(invoiceMapper::toDto)
                .toList();
    }

    @Override
    public InvoiceDTO getInvoiceById(Long id) {
        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found"));
        return invoiceMapper.toDto(invoice);
    }

    @Override
    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }
}
