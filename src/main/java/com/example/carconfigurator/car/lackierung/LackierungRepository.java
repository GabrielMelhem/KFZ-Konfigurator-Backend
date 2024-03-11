package com.example.carconfigurator.car.lackierung;

import com.example.carconfigurator.car.motorleistung.Motorleistung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LackierungRepository extends JpaRepository<Lackierung, Long> {

}
