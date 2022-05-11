package com.example.wcrud.api.controller;

import com.example.wcrud.api.dtos.AddressRequestDTO;
import com.example.wcrud.api.dtos.AddressResponseDTO;
import com.example.wcrud.api.mapper.AddressMapper;
import com.example.wcrud.api.model.Address;
import com.example.wcrud.api.service.AddressService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.*;


@RequestMapping("/address/")
@RestController
public class AddressController {

    private final AddressService addressService;
    private final AddressMapper addressMapper;

    public AddressController(AddressService addressService, AddressMapper addressMapper) {
        this.addressService = addressService;
        this.addressMapper = addressMapper;
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public AddressResponseDTO save(@RequestBody @Valid final AddressRequestDTO addressRequestDTO) {
        Address address = addressService.save(addressMapper.toDomain(addressRequestDTO));
        return addressMapper.fromDomain(address);
    }

    @ResponseStatus(OK)
    @GetMapping("{id}")
    public AddressResponseDTO findById(@PathVariable final Long id) {
        return addressMapper.fromDomain(addressService.findById(id));
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable final Long id) {
        addressService.deleteById(id);
    }
}
