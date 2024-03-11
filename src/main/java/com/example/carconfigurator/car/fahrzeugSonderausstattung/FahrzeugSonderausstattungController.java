package com.example.carconfigurator.car.fahrzeugSonderausstattung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/fahrzeugSonderausstattungen")
public class FahrzeugSonderausstattungController {

    private final FahrzeugSonderausstattungService fahrzeugSonderausstattungService;

    @Autowired
    public FahrzeugSonderausstattungController(FahrzeugSonderausstattungService fahrzeugSonderausstattungService) {
        this.fahrzeugSonderausstattungService = fahrzeugSonderausstattungService;
    }

    // Abrufen einer Sonderausstattung nach ID
    @GetMapping("api/v1//{id}")
    public ResponseEntity<FahrzeugSonderausstattung> getFahrzeugSonderausstattungById(@PathVariable Long id) {
        return fahrzeugSonderausstattungService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Hinzufügen einer neuen Sonderausstattung
    @PostMapping
    public FahrzeugSonderausstattung addFahrzeugSonderausstattung(@RequestBody FahrzeugSonderausstattung fahrzeugSonderausstattung) {
        return fahrzeugSonderausstattungService.save(fahrzeugSonderausstattung);
    }

    // Löschen einer Sonderausstattung nach ID
    @DeleteMapping("api/v1//{id}")
    public void deleteFahrzeugSonderausstattung(@PathVariable Long id) {
        fahrzeugSonderausstattungService.deleteById(id);
    }


}
