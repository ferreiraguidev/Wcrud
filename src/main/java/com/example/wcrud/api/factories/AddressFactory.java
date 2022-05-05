package com.example.wcrud.api.factories;

import com.example.wcrud.api.dtos.ViaCEPResponseDTO;
import com.example.wcrud.api.model.Address;
import org.springframework.stereotype.Component;

import java.time.LocalDate;




@Component
public class AddressFactory {

    public Address viaCEPToAddress(ViaCEPResponseDTO viaCEPResponseDTO, Address address){

        Address addressFactory = new Address();
        addressFactory.setBairro(viaCEPResponseDTO.getBairro());
        addressFactory.setLocalidade(viaCEPResponseDTO.getLocalidade());
        addressFactory.setUf(viaCEPResponseDTO.getUf());
        addressFactory.setCep(viaCEPResponseDTO.getCep());
        addressFactory.setLogradouro(viaCEPResponseDTO.getLogradouro());
        addressFactory.setCreatedAt(LocalDate.now());
        addressFactory.setCustomer(address.getCustomer());

        return addressFactory;
    }
}
