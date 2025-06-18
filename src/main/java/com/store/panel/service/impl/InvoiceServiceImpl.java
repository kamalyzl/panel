package com.store.panel.service.impl;

import com.store.panel.entity.Customer;
import com.store.panel.entity.Invoice;
import com.store.panel.entity.Product;
import com.store.panel.repository.CustomerRepository;
import com.store.panel.repository.InvoiceRepository;
import com.store.panel.repository.ProductRepository;
import com.store.panel.service.interfaces.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements IInvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice save(Invoice invoice) {
        // Validar existencia de Customer y Products
        Customer customer = customerRepository.findById(invoice.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        invoice.setCustomer(customer);

        List<Product> validatedProducts = invoice.getProducts().stream()
                .map(p -> productRepository.findById(p.getId())
                        .orElseThrow(() -> new RuntimeException("Product not found: " + p.getId())))
                .collect(Collectors.toList());
        invoice.setProducts(validatedProducts);

        return invoiceRepository.save(invoice);
    }
}