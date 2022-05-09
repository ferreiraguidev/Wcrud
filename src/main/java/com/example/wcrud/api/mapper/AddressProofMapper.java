package com.example.wcrud.api.mapper;


import com.example.wcrud.api.dtos.AddressProofResponseDTO;
import com.example.wcrud.api.model.AddressProof;
import com.example.wcrud.api.service.AddressService;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AddressService.class})
public interface AddressProofMapper {

    AddressProofResponseDTO fromDomain(AddressProof entity);
}
