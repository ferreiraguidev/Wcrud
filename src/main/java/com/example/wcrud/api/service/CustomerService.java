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

    public Customer save(final Customer customer) {
        return repository.save(customer);
    }

    public void deleteById(final Long id) {
        repository.deleteById(id);
    }

    public Customer findById(final Long id) {
        return repository.findById(id).orElseThrow(NullPointerException::new);
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }

}