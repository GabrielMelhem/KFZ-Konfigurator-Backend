package com.example.carconfigurator.car.images;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.*;


@RestController
@RequestMapping(path = "api/v1/image")
public class FileDataController {


    private StorageService service;

    @Autowired
    public FileDataController(StorageService service) {
        this.service = service;
    }


   @Autowired
   private ServletContext servletContext;

   @GetMapping("/fileSystem/{fileName}")
   public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String fileName) {
       try {
           Path filePath = service.getFilePath(fileName); // Ensure this method exists and correctly constructs the file path
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
            String uploadImagePath = service.uploadImageToFileSystem(file);
            System.out.println("Uploading file: " + file.getOriginalFilename());
            System.out.println("File size: " + file.getSize());
            System.out.println("Content type: " + file.getContentType());
            return ResponseEntity.ok().body("File uploaded successfully: " + uploadImagePath);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Failed to upload image: " + e.getMessage());
        }
    }
}
/*curl -X POST -F "image=@/Users/gabimelhem/Documents/Projects/images/5GKlass.png" http://localhost:8080/api/v1/image/fileSystem
xcj-jzxz-ndw*/