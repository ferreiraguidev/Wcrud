package com.example.wcrud.api.mapper;

import com.example.wcrud.api.dtos.AddressRequestDTO;
import com.example.wcrud.api.dtos.AddressResponseDTO;
import com.example.wcrud.api.model.Address;
import com.example.wcrud.api.service.AddressService;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring", uses = {AddressService.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AddressMapper {

    @Mapping(source ="customerId",target = "customer")
    Address toDomain(AddressRequestDTO requestDTO);

    AddressResponseDTO fromDomain(Address entity);

    List<AddressResponseDTO> fromDomainList(List<Address> entityList);
}
