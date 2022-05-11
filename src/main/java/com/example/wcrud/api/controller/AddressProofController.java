package com.example.wcrud.api.controller;


import com.example.wcrud.api.dtos.AddressProofResponseDTO;
import com.example.wcrud.api.mapper.AddressProofMapper;
import com.example.wcrud.api.service.AddressProofService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
public class AddressProofController {

    private final AddressProofService addressProofService;
    private final AddressProofMapper addressProofMapper;

    public AddressProofController(AddressProofService addressProofService, AddressProofMapper addressProofMapper) {
        this.addressProofService = addressProofService;
        this.addressProofMapper = addressProofMapper;
    }

    @PostMapping("/upload")
    public AddressProofResponseDTO save(@RequestParam("image") final MultipartFile image, @RequestParam("id") final Long id) throws IOException {
        return addressProofMapper.fromDomain(addressProofService.save(image,id));
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable final Long id) throws IOException {
        addressProofService.deleteAddressProof(id);
    }
}