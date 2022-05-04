package com.example.wcrud.api.service;

import com.example.wcrud.api.model.Address;
import com.example.wcrud.api.model.ViaCep;
import com.example.wcrud.api.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository repository;

    private final CepService cepService;

    public AddressService(AddressRepository repository, CepService cepService) {
        this.repository = repository;
        this.cepService = cepService;
    }

    public Address save(Address address) {
//
//        ViaCep cep = new ViaCep();
//
//        if(cep.getCep() != null){
//            cepService.getCep(cepp);
//        }
       return repository.save(address);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Address findById(Long id) {
        return repository.findById(id).orElseThrow(NullPointerException::new);
    }
}
