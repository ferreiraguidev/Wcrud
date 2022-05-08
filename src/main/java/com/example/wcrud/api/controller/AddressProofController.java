package com.example.wcrud.api.controller;


import com.example.wcrud.api.service.ImageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class AddressProofController {

    private final ImageService fileUploadService;

    public AddressProofController(ImageService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @PostMapping("/upload")
    public void save(@RequestParam("image") final MultipartFile image, @RequestParam("id") final Long id) throws IOException {
        fileUploadService.saveImage(image, id);
    }
}

