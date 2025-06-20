package com.store.panel.service.impl;

import com.store.panel.entity.Customer;
import com.store.panel.exception.ResourceNotFoundException;
import com.store.panel.repository.CustomerRepository;
import com.store.panel.dto.CustomerDTO;
import com.store.panel.mapper.CustomerMapper;
import com.store.panel.service.interfaces.ICustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements ICustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDTO> getAllCustomerDTOs() {
        log.info("[SERVICE] Fetching all customers");
        List<Customer> customers = customerRepository.findAll();
        log.debug("[DB] Found {} customers", customers.size());
        return customers.stream()
                .map(customerMapper::toDto)
                .toList();
    }

    @Override
    public CustomerDTO getCustomerDTOById(Long id) {
        Customer customer  = customerRepository
                .findById(id).orElseThrow(() ->  new ResourceNotFoundException("Customer not found"));
        return customerMapper.toDto(customer);
    }

    @Override
    public CustomerDTO createCustomerFromDTO(CustomerDTO dto) {
        log.info("[SERVICE] Creating customer with name: {} {}", dto.getName(), dto.getLastname());
        Customer entity = customerMapper.toEntity(dto);
        log.debug("[MAPPER] Mapped entity: {}", entity);
        Customer saved = customerRepository.save(entity);
        log.info("[DB] Customer created with ID: {}", saved.getId());
        return customerMapper.toDto(saved);
    }

    @Override
    public Optional<CustomerDTO> updateCustomerFromDTO(Long id, CustomerDTO dto) {
        return customerRepository.findById(id).map(existing -> {
            existing.setName(dto.getName());
            existing.setLastname(dto.getLastname());
            existing.setDni(dto.getDni());
            existing.setAddress(dto.getAddress());
            existing.setNumberPhone(dto.getNumberPhone());
            existing.setEmail(dto.getEmail());
            Customer updated = customerRepository.save(existing);
            return customerMapper.toDto(updated);
        });
    }

    @Override
    public boolean deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
