package com.example.carconfigurator.car.fahrzeugSonderausstattung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FahrzeugSonderausstattungService {

    private final FahrzeugSonderausstattungRepository fahrzeugSonderausstattungRepository;

    @Autowired
    public FahrzeugSonderausstattungService(FahrzeugSonderausstattungRepository fahrzeugSonderausstattungRepository) {
        this.fahrzeugSonderausstattungRepository = fahrzeugSonderausstattungRepository;
    }

    public List<FahrzeugSonderausstattung> findAll() {
        return fahrzeugSonderausstattungRepository.findAll();
    }

    public Optional<FahrzeugSonderausstattung> findById(Long id) {
        return fahrzeugSonderausstattungRepository.findById(id);
    }

    public FahrzeugSonderausstattung save(FahrzeugSonderausstattung fahrzeugSonderausstattung) {
        return fahrzeugSonderausstattungRepository.save(fahrzeugSonderausstattung);
    }

    public void deleteById(Long id) {
        fahrzeugSonderausstattungRepository.deleteById(id);
    }
}
