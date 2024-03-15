package com.example.carconfigurator.car.fahrzeuge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FahrzeugeRepository extends JpaRepository<Fahrzeuge, Long> {
    List<Fahrzeuge> findByModell(String modell);
}
