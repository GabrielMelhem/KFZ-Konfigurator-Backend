package com.example.carconfigurator.car.bilder;

import com.example.carconfigurator.car.images.FileData;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class BilderService {

    private final BilderRepository bilderRepository;

    @Autowired
    public BilderService(BilderRepository bilderRepository) {
        this.bilderRepository = bilderRepository;
    }


    public List<Bilder> getBilder(){return bilderRepository.findAll();}


    public byte[] downloadImageFromFileSystem(String bildName) throws IOException {
        Bilder bild = bilderRepository.findByName(bildName)
                .orElseThrow(() -> new IOException("File not found with name: " + bildName));
        String bildPath = bild.getBildPath();
        return Files.readAllBytes(new File(bildPath).toPath());
    }


    public String uploadImageToFileSystem(MultipartFile file, String originalFileName) throws IOException {
        Path storageDirectory = Paths.get("/Users/gabimelhem/Desktop/MyFiles");
        if (!Files.exists(storageDirectory)) {
            Files.createDirectories(storageDirectory);
        }
        // Resolve the file path to save the file
        Path destinationFilePath = storageDirectory.resolve(originalFileName);
        // Save the file to the file system
        file.transferTo(destinationFilePath);

        // Return the path or some identifier of the stored file
        return destinationFilePath.toString();

    }

    public Path getFilePath(String fileName) {
        Path rootLocation = Paths.get("/Users/gabimelhem/Desktop/MyFiles");
        return rootLocation.resolve(fileName);
    }


    public List<String> findBildPathsEndingWithName(String suffix) {
        return bilderRepository.findBildPathByBildNameEndingWith(suffix);
    }
}
