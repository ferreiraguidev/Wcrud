package com.example.wcrud.api.controller;

import com.example.wcrud.api.dtos.CustomerRequestDTO;
import com.example.wcrud.api.dtos.CustomerResponseDTO;
import com.example.wcrud.api.mapper.CustomerMapper;
import com.example.wcrud.api.model.Customer;
import com.example.wcrud.api.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RequestMapping("/api/customer")
@RestController
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public CustomerResponseDTO save(@RequestBody @Valid CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerService.save(customerMapper.toDomain(customerRequestDTO));
        return customerMapper.fromDomain(customer);
    }

    @ResponseStatus(OK)
    @GetMapping("{id}")
    public CustomerResponseDTO findById(@PathVariable Long id) {
        return customerMapper.fromDomain(customerService.findById(id));
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        customerService.deleteById(id);
    }

    @ResponseStatus(OK)
    @GetMapping
    public List<CustomerResponseDTO> listAll() {
        return customerMapper.fromDomainList(customerService.findAll());
    }
}