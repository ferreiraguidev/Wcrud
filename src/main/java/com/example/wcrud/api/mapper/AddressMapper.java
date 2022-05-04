package com.example.wcrud.api.mapper;

import com.example.wcrud.api.dtos.AddressRequestDTO;
import com.example.wcrud.api.dtos.AddressResponseDTO;
import com.example.wcrud.api.model.Address;
import com.example.wcrud.api.service.CustomerService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring", uses = {CustomerService.class})
public interface AddressMapper {

    @Mapping(source ="customerId",target = "customer")
    Address toDomain(AddressRequestDTO requestDTO);

    AddressResponseDTO fromDomain(Address entity);

    List<AddressResponseDTO> fromDomainList(List<Address> entityList);
}
