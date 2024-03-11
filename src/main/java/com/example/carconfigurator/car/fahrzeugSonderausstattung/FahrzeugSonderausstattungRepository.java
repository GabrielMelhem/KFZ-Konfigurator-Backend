package com.example.carconfigurator.car.fahrzeugSonderausstattung;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FahrzeugSonderausstattungRepository extends JpaRepository<FahrzeugSonderausstattung, Long>{
}
