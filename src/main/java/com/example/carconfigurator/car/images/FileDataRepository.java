package com.example.carconfigurator.car.images;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FileDataRepository extends JpaRepository<FileData,Integer> {
    Optional<FileData> findByName(String fileName);


    // Using JPQL to find files with names that end with a specific suffix
    @Query("SELECT fd.filePath FROM FileData fd WHERE fd.name LIKE %?1")
    List<String> findFilePathByFileNameEndingWith(String suffix);
}
