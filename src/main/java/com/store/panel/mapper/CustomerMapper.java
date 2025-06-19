package com.store.panel.mapper;

import com.store.panel.dto.CustomerDTO;
import com.store.panel.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toEntity(CustomerDTO dto) {
        if (dto == null) return null;
        return Customer.builder()
                .id(dto.getId())
                .name(dto.getName())
                .lastname(dto.getLastname())
                .dni(dto.getDni())
                .address(dto.getAddress())
                .numberPhone(dto.getNumberPhone())
                .email(dto.getEmail())
                .build();
    }

    public CustomerDTO toDto(Customer entity) {
        if (entity == null) return null;
        return CustomerDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .lastname(entity.getLastname())
                .dni(entity.getDni())
                .address(entity.getAddress())
                .numberPhone(entity.getNumberPhone())
                .email(entity.getEmail())
                .build();
    }
}
