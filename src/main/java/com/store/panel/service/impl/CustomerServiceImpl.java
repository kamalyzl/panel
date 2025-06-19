package com.store.panel.service.impl;

import com.store.panel.entity.Customer;
import com.store.panel.repository.CustomerRepository;
import com.store.panel.dto.CustomerDTO;
import com.store.panel.mapper.CustomerMapper;
import com.store.panel.service.interfaces.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDTO> getAllCustomerDTOs() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerDTO> getCustomerDTOById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::toDto);
    }

    @Override
    public CustomerDTO createCustomerFromDTO(CustomerDTO dto) {
        System.out.println("DTO recibido: {}" + dto);
        Customer entity = customerMapper.toEntity(dto);  // ← importante
        System.out.println("Entidad generada: {}" + entity);
        Customer saved = customerRepository.save(entity);
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
