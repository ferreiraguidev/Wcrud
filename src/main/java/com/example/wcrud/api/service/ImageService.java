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


    public String saveImage(final MultipartFile image, final String path) throws IOException {
        byte[] bytes = image.getBytes();
        String extension = getExtension(image);
        var fileName = UUID.randomUUID() + "." + extension;

        if(!validatedExtension(extension)){
            throw new FileNotSupportedExcepiton("File not supported ! Verify the type");
        }

        File file = new File(path);

        if(!file.exists()){
            file.mkdir();
        }

        return Files.write(Path.of(path + fileName), bytes).toAbsolutePath().toString();
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
