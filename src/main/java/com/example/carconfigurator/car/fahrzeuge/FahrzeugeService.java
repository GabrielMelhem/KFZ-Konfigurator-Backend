package com.example.carconfigurator.car.fahrzeuge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FahrzeugeService {

    private final FahrzeugeRepository fahrzeugeRepository;

    @Autowired
    public FahrzeugeService(FahrzeugeRepository fahrzeugeRepository) {
        this.fahrzeugeRepository = fahrzeugeRepository;
    }

    public List<Fahrzeuge> getFahrzeuge() {return fahrzeugeRepository.findAll();}

    public Optional<Fahrzeuge> findById(Long id) {
        return fahrzeugeRepository.findById(id);
    }

    public Fahrzeuge save(Fahrzeuge fahrzeug) {
        return fahrzeugeRepository.save(fahrzeug);
    }

    public void deleteById(Long id) {
        fahrzeugeRepository.deleteById(id);
    }
    
}
