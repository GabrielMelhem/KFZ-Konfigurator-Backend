package com.example.carconfigurator.car.bestellungen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/bestellungen")
public class BestellungenController {
    private final BestellungenService bestellungenService;

    @Autowired
    public BestellungenController(BestellungenService bestellungenService) {
        this.bestellungenService = bestellungenService;
    }

    @PostMapping
    public Bestellungen addBestellung(@RequestBody Bestellungen bestellung) {
        return bestellungenService.saveBestellung(bestellung);
    }
}
