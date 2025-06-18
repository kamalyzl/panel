package com.store.panel.controller;

import com.store.panel.dto.CustomerDTO;
import com.store.panel.entity.Customer;
import com.store.panel.mapper.CustomerMapper;
import com.store.panel.service.interfaces.ICustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customers")
@Validated
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private CustomerMapper customerMapper;

    @GetMapping
    public List<CustomerDTO> getAll() {
        return customerService.findAll()
                .stream()
                .map(customerMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> create(@Valid @RequestBody CustomerDTO dto) {
        Customer saved = customerService.save(customerMapper.toEntity(dto));
        return ResponseEntity.ok(customerMapper.toDto(saved));
    }
}
