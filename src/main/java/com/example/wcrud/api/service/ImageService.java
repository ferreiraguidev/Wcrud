package com.example.wcrud.api.service;

import com.example.wcrud.api.exceptions.FileNotSupportedExcepiton;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ImageService {

    private static final String PATH = "./file/";

    public void saveImage(final MultipartFile image, final Long id) throws IOException {
        byte[] bytes = image.getBytes();
        String extension = getExtension(image);
        var fileName = UUID.randomUUID() + "." + extension;

        if(!validatedExtension(extension)){
            throw new FileNotSupportedExcepiton("File not supported ! Verify the type");
        }

        File file = new File(PATH);

        if(!file.exists()){
            file.mkdir();
        }

        Files.write(Path.of(PATH + fileName), bytes);
    }

    private String getExtension(MultipartFile image) {
        return Optional.ofNullable(
                image.getOriginalFilename()).filter(file-> file.contains("."))
                .map(file-> file.substring(image.getOriginalFilename().lastIndexOf(".")+ 1)).get();
    }

    private boolean validatedExtension(String extension){
        return List.of("jpg","png","jpeg","pdf").contains(extension);
    }
}
