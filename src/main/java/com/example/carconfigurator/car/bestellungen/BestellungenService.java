package com.example.carconfigurator.car.bestellungen;

import com.example.carconfigurator.car.fahrzeuge.Fahrzeuge;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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


    public Bestellungen finalizeBestellung(String slug) {
        Optional<Bestellungen> bestellungOpt = bestellungenRepository.findByUrlSlug( slug);
        if (bestellungOpt.isPresent()) {
            Bestellungen bestellung = bestellungOpt.get();
            bestellung.setIsFinalized(true);
            return bestellungenRepository.save(bestellung);
        } else {
            throw new EntityNotFoundException("Bestellung not found with slug: " + slug);
        }
    }

    public List<Bestellungen> getBestellungen() {return bestellungenRepository.findAll();}
}


