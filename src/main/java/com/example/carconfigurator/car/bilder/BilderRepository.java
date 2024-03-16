package com.example.carconfigurator.car.bilder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BilderRepository extends JpaRepository<Bilder, Long> {
    Optional<Bilder> findByName(String bildName);

    @Query("SELECT b.bildPath FROM Bilder b WHERE b.name LIKE %?1")
    List<String> findBildPathByBildNameEndingWith(String suffix);
}
