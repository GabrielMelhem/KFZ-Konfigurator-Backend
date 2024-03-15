package com.example.carconfigurator.car.bestellungen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BestellungenService {

    private final BestellungenRepository bestellungenRepository;

    @Autowired
    public BestellungenService(BestellungenRepository bestellungenRepository) {
        this.bestellungenRepository = bestellungenRepository;
    }

    public Bestellungen saveBestellung(Bestellungen bestellung) {
        return bestellungenRepository.save(bestellung);
    }
}
