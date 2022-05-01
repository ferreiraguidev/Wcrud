package com.example.wcrud.api.mapper;

import com.example.wcrud.api.dtos.CustomerRequestDTO;
import com.example.wcrud.api.dtos.CustomerResponseDTO;
import com.example.wcrud.api.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends EntityMapper<Customer, CustomerRequestDTO, CustomerResponseDTO> {
}