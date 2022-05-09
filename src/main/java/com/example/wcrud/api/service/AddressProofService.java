package com.example.wcrud.api.service;

import com.example.wcrud.api.model.AddressProof;
import com.example.wcrud.api.repository.AddressProofRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class AddressProofService {

    private final ImageService imageService;
    private final AddressProofRepository addressProofRepository;
    private final AddressService addressService;

    private static final String PATH = "./address-proof/";

    public AddressProofService(ImageService imageService, AddressProofRepository addressProofRepository,AddressService addressService) {
        this.imageService = imageService;
        this.addressProofRepository = addressProofRepository;
        this.addressService = addressService;

    }

    public AddressProof save(final MultipartFile file, final Long id) throws IOException {
        String path = imageService.saveImage(file, PATH);

        AddressProof addressProof = new AddressProof();
        addressProof.setPath(path);
        addressProof.setCreatedAt(LocalDateTime.now());
        addressProof.setAddress(addressService.findById(id));

        return addressProofRepository.save(addressProof);
    }

}
