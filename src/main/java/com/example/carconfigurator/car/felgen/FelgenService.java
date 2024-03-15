package com.example.carconfigurator.car.felgen;

import com.example.carconfigurator.car.fahrzeuge.Fahrzeuge;
import com.example.carconfigurator.car.fahrzeuge.FahrzeugeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FelgenService {

    private final FelgenRepository felgenRepository;
    private final FahrzeugeRepository fahrzeugeRepository;

    @Autowired
    public FelgenService(FelgenRepository felgenRepository, FahrzeugeRepository fahrzeugeRepository) {
        this.felgenRepository = felgenRepository;
        this.fahrzeugeRepository = fahrzeugeRepository;
    }

    public List<Felgen> getFelgen() {return felgenRepository.findAll();}

    public List<Felgen> getFelgenByFahrzeugModell(String modell){
        List<Fahrzeuge> fahrzeugeList = fahrzeugeRepository.findByModell(modell);
        return fahrzeugeList.stream()
                .map(Fahrzeuge::getFelgen)
                .distinct()
                .collect(Collectors.toList());
    }
}
