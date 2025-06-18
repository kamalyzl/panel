package com.store.panel.service.interfaces;

import com.store.panel.entity.Invoice;

import java.util.List;

public interface IInvoiceService {
    List<Invoice> findAll();
    Invoice save(Invoice invoice);
}
