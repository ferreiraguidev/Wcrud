package com.example.wcrud.api.service;

import com.example.wcrud.api.model.Address;
import com.example.wcrud.api.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository repository;

    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    public Address save(Address address) {
        return repository.save(address);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Address findById(Long id) {
        return repository.findById(id).orElseThrow(NullPointerException::new);
    }

    public List<Address> findAll() {
        return repository.findAll();

    }
}