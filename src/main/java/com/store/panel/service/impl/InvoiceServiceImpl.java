package com.store.panel.service.impl;

import com.store.panel.entity.Invoice;
import com.store.panel.repository.InvoiceRepository;
import com.store.panel.service.interfaces.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements IInvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public Optional<Invoice> getInvoiceById(Long id) {
        return invoiceRepository.findById(id);
    }

    @Override
    public Invoice createInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Optional<Invoice> updateInvoice(Long id, Invoice invoice) {
        return invoiceRepository.findById(id).map(existing -> {
            existing.setDate(invoice.getDate());
            existing.setCustomer(invoice.getCustomer());
            existing.setProducts(invoice.getProducts());
            return invoiceRepository.save(existing);
        });
    }

    @Override
    public boolean deleteInvoice(Long id) {
        if (invoiceRepository.existsById(id)) {
            invoiceRepository.deleteById(id);
            return true;
        }
        return false;
    }
}