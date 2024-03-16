package com.example.carconfigurator.car.bestellungen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public  ResponseEntity<Bestellungen> addBestellung(@RequestBody Bestellungen bestellung) {
        Bestellungen savedBestellung = bestellungenService.saveBestellung(bestellung);
        return ResponseEntity.ok(savedBestellung);
    }

    @GetMapping("/{slug}")
    public ResponseEntity<Bestellungen> getBestellungBySlug(@PathVariable String slug) {
        return bestellungenService.findBySlug(slug)
                        .map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
