package com.example.wcrud.api.service;

import com.example.wcrud.api.dtos.ViaCEPResponseDTO;
import com.example.wcrud.api.factories.AddressFactory;
import com.example.wcrud.api.model.Address;
import com.example.wcrud.api.repository.AddressRepository;
import com.example.wcrud.api.repository.ViaCepClient;
import org.springframework.stereotype.Service;

@Service
public class AddressService {


    private final AddressRepository repository;
    private final ViaCepClient viaCepClient;
    private final AddressFactory addressFactory;

    public AddressService(AddressRepository repository, ViaCepClient viaCepClient, AddressFactory addressFactory) {
        this.repository = repository;
        this.viaCepClient = viaCepClient;
        this.addressFactory = addressFactory;
    }

    public Address save(Address address) {
        ViaCEPResponseDTO viaCEPResponseDTO = viaCepClient.buscaPorEndereco(address.getCep());
        Address cepToAddress = addressFactory.viaCEPToAddress(viaCEPResponseDTO, address);
        return repository.save(cepToAddress);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Address findById(Long id) {
        return repository.findById(id).orElseThrow(NullPointerException::new);
    }
}
