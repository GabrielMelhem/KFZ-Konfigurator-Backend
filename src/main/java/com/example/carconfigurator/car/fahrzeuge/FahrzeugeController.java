package com.example.carconfigurator.car.fahrzeuge;

import com.example.carconfigurator.car.motorleistung.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/fahrzeuge")
public class FahrzeugeController {

    private final FahrzeugeService fahrzeugeService;

    @Autowired
    public FahrzeugeController(FahrzeugeService fahrzeugeService) {
        this.fahrzeugeService = fahrzeugeService;
    }

    @GetMapping
    public List<Fahrzeuge> getFahrzeuge(){return fahrzeugeService.getFahrzeuge();}

    // Abrufen eines Fahrzeugs nach ID
    @GetMapping("api/v1/{id}")
    public ResponseEntity<Fahrzeuge> getFahrzeugById(@PathVariable Long id) {
        return fahrzeugeService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Hinzufügen eines neuen Fahrzeugs
    @PostMapping
    public Fahrzeuge addFahrzeug(@RequestBody Fahrzeuge fahrzeug) {
        return fahrzeugeService.save(fahrzeug);
    }


    // Aktualisieren eines Fahrzeugs
    @PutMapping("api/v1/{id}")
    public ResponseEntity<Fahrzeuge> updateFahrzeug(@PathVariable Long id, @RequestBody Fahrzeuge fahrzeugDetails) {
        return fahrzeugeService.findById(id)
                .map(fahrzeug -> {
                    fahrzeug.setMarke(fahrzeugDetails.getMarke());
                    fahrzeug.setModell(fahrzeugDetails.getModell());
                    Fahrzeuge updatedFahrzeug = fahrzeugeService.save(fahrzeug);
                    return ResponseEntity.ok(updatedFahrzeug);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Löschen eines Fahrzeugs nach ID
    @DeleteMapping("api/v1/{id}")
    public ResponseEntity<Void> deleteFahrzeug(@PathVariable Long id) {
        return fahrzeugeService.findById(id)
                .map(fahrzeug -> {
                    fahrzeugeService.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

