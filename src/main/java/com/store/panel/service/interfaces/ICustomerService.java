package com.store.panel.service.interfaces;

import com.store.panel.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> getAllCustomers();
    Optional<Customer> getCustomerById(Long id);
    Customer createCustomer(Customer customer);
    Optional<Customer> updateCustomer(Long id, Customer customer);
    boolean deleteCustomer(Long id);
}
