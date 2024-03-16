package com.example.carconfigurator.car.bilder;

import com.example.carconfigurator.car.images.FileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BilderRepository extends JpaRepository<Bilder, Long> {
    Optional<Bilder> findByName(String bildName);
}
