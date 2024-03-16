package com.example.carconfigurator.car.bestellungen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BestellungenRepository extends JpaRepository<Bestellungen, Long> {
    Optional<Bestellungen> findByUrlSlug(String urlSlug);
}
