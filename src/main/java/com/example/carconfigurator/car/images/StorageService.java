package com.example.carconfigurator.car.images;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class StorageService {

    @Autowired
    private FileDataRepository fileDataRepository;

    /*private final Path rootLocation = Paths.get("/Users/gabimelhem/Desktop/MyFiles");*/

    public String uploadImageToFileSystem(MultipartFile file, String originalFileName) throws IOException {
        /*String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path savePath = this.rootLocation.resolve(filename);

        Files.createDirectories(this.rootLocation); // Ensure the directory exists
        Files.copy(file.getInputStream(), savePath); // Save the file

        return savePath.toString();*/

        Path storageDirectory = Paths.get("/Users/gabimelhem/Desktop/MyFiles");
        if (!Files.exists(storageDirectory)) {
            Files.createDirectories(storageDirectory);
        }
        // Resolve the file path to save the file
        Path destinationFilePath = storageDirectory.resolve(originalFileName);
        // Save the file to the file system
        file.transferTo(destinationFilePath);



        // After saving the file, create a new FileData entity
        FileData fileData = new FileData();
        fileData.setName(originalFileName);
        fileData.setType(file.getContentType());
        fileData.setFilePath(destinationFilePath.toString());

        // Save the fileData entity to the database
        fileDataRepository.save(fileData);


        // Return the path or some identifier of the stored file
        return destinationFilePath.toString();


    }

    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        FileData fileData = fileDataRepository.findByName(fileName)
                .orElseThrow(() -> new IOException("File not found with name: " + fileName));
        String filePath = fileData.getFilePath();
        return Files.readAllBytes(new File(filePath).toPath());
    }

    public Path getFilePath(String fileName) {
        Path rootLocation = Paths.get("/Users/gabimelhem/Desktop/MyFiles");
        return rootLocation.resolve(fileName);
    }



}
