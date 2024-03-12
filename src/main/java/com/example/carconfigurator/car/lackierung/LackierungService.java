package com.example.carconfigurator.car.lackierung;

import com.example.carconfigurator.car.fahrzeuge.Fahrzeuge;
import com.example.carconfigurator.car.fahrzeuge.FahrzeugeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LackierungService {

    private final LackierungRepository lackierungRepository;
    private final FahrzeugeRepository fahrzeugeRepository;

    @Autowired
    public LackierungService(LackierungRepository lackierungRepository, FahrzeugeRepository fahrzeugeRepository) {
        this.lackierungRepository = lackierungRepository;
        this.fahrzeugeRepository = fahrzeugeRepository;
    }



    public List <Lackierung> getLackierungen() {return lackierungRepository.findAll();}

    public List <Lackierung> getLackierungenByFahrzeugModell(String modell){
        List<Fahrzeuge> fahrzeugeList = fahrzeugeRepository.findByModell(modell);
        return fahrzeugeList.stream()
                .map(Fahrzeuge::getLackierung)
                .distinct()
                .collect(Collectors.toList());
    }
}
