package com.example.wcrud.api.service;

import com.example.wcrud.api.model.Customer;
import com.example.wcrud.api.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Customer findById(Long id) {
        return repository.findById(id).orElseThrow(NullPointerException::new);
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }

}