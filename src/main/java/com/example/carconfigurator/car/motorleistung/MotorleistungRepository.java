package com.example.carconfigurator.car.motorleistung;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MotorleistungRepository extends JpaRepository<Motorleistung, Long> {
}
