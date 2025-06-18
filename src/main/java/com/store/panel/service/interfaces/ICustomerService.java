package com.store.panel.service.interfaces;

import com.store.panel.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer save(Customer customer);
}
