package com.example.carconfigurator.car.fahrzeuge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FahrzeugeRepository extends JpaRepository<Fahrzeuge, Long> {
}
