package com.example.carconfigurator.car.felgen;

import com.example.carconfigurator.car.motorleistung.Motorleistung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FelgenRepository extends JpaRepository<Felgen, Long> {
}
