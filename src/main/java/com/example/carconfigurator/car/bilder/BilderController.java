package com.example.carconfigurator.car.bilder;


import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/bilder")
public class BilderController {
    private final BilderService bilderService;

    @Autowired
    public BilderController(BilderService bilderService) {
        this.bilderService = bilderService;
    }

    @Autowired
    private ServletContext servletContext;

    @GetMapping
    public List<Bilder> getBilder(){return bilderService.getBilder();}


    @GetMapping("/fileSystem/{fileName}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String fileName) {
        try {
            Path filePath = bilderService.getFilePath(fileName);
            if (Files.exists(filePath)) {
                String mimeType = servletContext.getMimeType(filePath.toString());
                if (mimeType == null) {
                    mimeType = "application/octet-stream";
                }

                UrlResource resource = new UrlResource(filePath.toUri());
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(mimeType))
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Error retrieving file: " + e.getMessage());
        }
    }



    @PostMapping(value ="/fileSystem", consumes = "multipart/form-data")
    public ResponseEntity<?> uploadImageToFileSystem(@RequestParam("image") MultipartFile file) {
        try {
            String originalFileName = file.getOriginalFilename();
            String uploadImagePath = bilderService.uploadImageToFileSystem(file, originalFileName);
            System.out.println("Uploading file: " + file.getOriginalFilename());
            System.out.println("File size: " + file.getSize());
            System.out.println("Content type: " + file.getContentType());
            return ResponseEntity.ok().body("File uploaded successfully: " + uploadImagePath);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Failed to upload image: " + e.getMessage());
        }
    }


    @GetMapping("/fileSystem/endwith/{suffix}")
    public ResponseEntity<List<String>> getBildPathsBySuffix(@PathVariable String suffix) {
        List<String> filePaths = bilderService.findBildPathsEndingWithName(suffix);
        if(filePaths.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(filePaths);
    }
}
