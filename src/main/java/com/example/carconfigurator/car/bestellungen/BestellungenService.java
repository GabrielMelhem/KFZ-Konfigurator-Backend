package com.example.carconfigurator.car.bestellungen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BestellungenService {

    private final BestellungenRepository bestellungenRepository;

    @Autowired
    public BestellungenService(BestellungenRepository bestellungenRepository) {
        this.bestellungenRepository = bestellungenRepository;
    }

    public Bestellungen saveBestellung(Bestellungen bestellung) {
        if (bestellung.getUrlSlug() == null || bestellung.getUrlSlug().isEmpty()) {

            String slug = UUID.randomUUID().toString();
            bestellung.setUrlSlug(slug);
        }
        return bestellungenRepository.save(bestellung);
    }

    // Method to find a Bestellung by its slug
    public Optional<Bestellungen> findBySlug(String slug) {
        return bestellungenRepository.findByUrlSlug(slug);
    }
}


