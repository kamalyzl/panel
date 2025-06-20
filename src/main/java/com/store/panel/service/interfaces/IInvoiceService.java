package com.store.panel.service.interfaces;

import com.store.panel.dto.InvoiceDTO;

import java.util.List;

public interface IInvoiceService {
    InvoiceDTO createInvoice(InvoiceDTO invoiceDTO);
    List<InvoiceDTO> getAllInvoices();
    InvoiceDTO getInvoiceById(Long id);
    void deleteInvoice(Long id);
}
