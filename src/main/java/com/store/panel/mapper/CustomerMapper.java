package com.store.panel.mapper;

import com.store.panel.dto.CustomerDTO;
import com.store.panel.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO toDto(Customer entity);
    Customer toEntity(CustomerDTO dto);
}
