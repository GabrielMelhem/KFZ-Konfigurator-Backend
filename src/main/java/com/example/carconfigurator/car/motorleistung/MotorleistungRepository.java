package com.example.carconfigurator.car.motorleistung;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorleistungRepository extends JpaRepository<Motorleistung, Long> {
}