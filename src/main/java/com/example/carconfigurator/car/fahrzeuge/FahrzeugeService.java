package com.example.carconfigurator.car.fahrzeuge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FahrzeugeService {

    private final FahrzeugeRepository fahrzeugeRepository;

    @Autowired
    public FahrzeugeService(FahrzeugeRepository fahrzeugeRepository) {
        this.fahrzeugeRepository = fahrzeugeRepository;
    }

    public List<Fahrzeuge> getFahrzeuge() {return fahrzeugeRepository.findAll();}

    
}
