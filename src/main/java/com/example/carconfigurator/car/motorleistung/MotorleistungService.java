package com.example.carconfigurator.car.motorleistung;

import com.example.carconfigurator.car.fahrzeuge.Fahrzeuge;
import com.example.carconfigurator.car.fahrzeuge.FahrzeugeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MotorleistungService {

    private final MotorleistungRepository motorleistungRepository;
    private final FahrzeugeRepository fahrzeugeRepository;

    @Autowired
    public MotorleistungService(MotorleistungRepository motorleistungRepository,FahrzeugeRepository fahrzeugeRepository) {
        this.motorleistungRepository = motorleistungRepository;
        this.fahrzeugeRepository = fahrzeugeRepository;
    }

    public List<Motorleistung> getMotorleistung() {return motorleistungRepository.findAll();}


    public List<Motorleistung> getMotorleistungByFahrzeugModell(String modell){
        // First, find all Fahrzeuge with the given modell
        List<Fahrzeuge> fahrzeugeList = fahrzeugeRepository.findByModell(modell);

        // Then, extract their Motorleistung entities
        return fahrzeugeList.stream()
                .map(Fahrzeuge::getMotorleistung) // Assuming getMotorleistung() is your getter method
                .distinct() // Optional, to avoid duplicates if multiple Fahrzeuge share the same Motorleistung
                .collect(Collectors.toList());
    }

}
