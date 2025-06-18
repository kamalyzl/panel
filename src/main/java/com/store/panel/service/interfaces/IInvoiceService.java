package com.store.panel.service.interfaces;

import com.store.panel.entity.Invoice;

import java.util.List;
import java.util.Optional;

public interface IInvoiceService {
    List<Invoice> getAllInvoices();
    Optional<Invoice> getInvoiceById(Long id);
    Invoice createInvoice(Invoice invoice);
    Optional<Invoice> updateInvoice(Long id, Invoice invoice);
    boolean deleteInvoice(Long id);
}
