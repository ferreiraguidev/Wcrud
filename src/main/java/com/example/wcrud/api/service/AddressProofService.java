package com.example.wcrud.api.service;

import com.example.wcrud.api.model.AddressProof;
import com.example.wcrud.api.repository.AddressProofRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import static org.apache.commons.io.FileUtils.forceDelete;

@Slf4j
@Service
public class AddressProofService {

    private final ImageService imageService;
    private final AddressProofRepository addressProofRepository;
    private final AddressService addressService;

    private static final String PATH = "./address-proof/";

    public AddressProofService(ImageService imageService, AddressProofRepository addressProofRepository, AddressService addressService) {
        this.imageService = imageService;
        this.addressProofRepository = addressProofRepository;
        this.addressService = addressService;

    }

    public AddressProof save(final MultipartFile file, final Long id) throws IOException {
        var addressProof = addressService.findById(id).getAddressProof();

        if (addressProof != null) {
            try {
                forceDelete(new File(addressProof.getPath()));
                log.info("Image was successfully overrode");

            } catch (Exception e) {
                log.info("ERROR: COULD NOT DELETE");
            }
        } else {
            addressProof = new AddressProof();
        }

        String path = imageService.saveImage(file, PATH);

        addressProof.setPath(path);
        addressProof.setCreatedAt(LocalDateTime.now());
        addressProof.setAddress(addressService.findById(id));

        return addressProofRepository.save(addressProof);
    }

    public void deleteAddressProof(Long id) throws IOException {
        var addressProof = addressService.findById(id).getAddressProof();
        addressProofRepository.deleteById(id);
        forceDelete(new File(addressProof.getPath()));
    }
}
