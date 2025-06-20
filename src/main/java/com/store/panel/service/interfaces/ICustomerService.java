package com.store.panel.service.interfaces;

import com.store.panel.dto.CustomerDTO;
import com.store.panel.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<CustomerDTO> getAllCustomerDTOs();
    CustomerDTO getCustomerDTOById(Long id);
    CustomerDTO createCustomerFromDTO(CustomerDTO customer);
    Optional<CustomerDTO> updateCustomerFromDTO(Long id, CustomerDTO customer);
    boolean deleteCustomer(Long id);
}
