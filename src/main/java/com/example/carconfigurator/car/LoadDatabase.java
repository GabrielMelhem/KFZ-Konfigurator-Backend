package com.example.carconfigurator.car;


import com.example.carconfigurator.car.fahrzeuge.*;
import com.example.carconfigurator.car.felgen.*;
import com.example.carconfigurator.car.lackierung.*;
import com.example.carconfigurator.car.motorleistung.*;
import com.example.carconfigurator.car.sonderausstattungen.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.List;
import java.util.Map;


@Configuration
public class LoadDatabase {
    @Value("classpath:${data.motorleistung}")
    private Resource motorleistungData;

    @Value("classpath:${data.lackierung}")
    private Resource lackierungData;

    @Value("classpath:${data.felgen}")
    private Resource felgenData;

    @Value("classpath:${data.sonderausstattungen}")
    private Resource sonderausstattungenData;

    @Value("classpath:${data.fahrzeuge}")
    private Resource fahrzeugeData;

    @Bean
    CommandLineRunner initDatabase(MotorleistungRepository motorleistungRepository,
                                   LackierungRepository lackierungRepository,
                                   FelgenRepository felgenRepository,
                                   SonderausstattungenRepository sonderausstattungenRepository,
                                   FahrzeugeRepository fahrzeugeRepository
                                   ) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            // Motorleistung
            List<Motorleistung> motorleistungen = mapper.readValue(motorleistungData.getInputStream(), new TypeReference<List<Motorleistung>>() {
            });
            motorleistungRepository.saveAll(motorleistungen);

            // Lackierung
            List<Lackierung> lackierungen = mapper.readValue(lackierungData.getInputStream(), new TypeReference<List<Lackierung>>() {
            });
            lackierungRepository.saveAll(lackierungen);

            // Felgen
            List<Felgen> felgenListe = mapper.readValue(felgenData.getInputStream(), new TypeReference<List<Felgen>>() {
            });
            felgenRepository.saveAll(felgenListe);

            //Sonderausstattungen
            List<Sonderausstattungen> sonderausstattungenListe = mapper.readValue(sonderausstattungenData.getInputStream(), new TypeReference<List<Sonderausstattungen>>() {
            });
            sonderausstattungenRepository.saveAll(sonderausstattungenListe);

            List<Fahrzeuge> fahrzeugeListe = mapper.readValue(fahrzeugeData.getInputStream(), new TypeReference<List<Fahrzeuge>>() {
            });
            fahrzeugeRepository.saveAll(fahrzeugeListe);


            /*
            Resource resource = new ClassPathResource("data/fahrzeuge.json");
            List<Map<String, String>> fahrzeuge = mapper.readValue(resource.getInputStream(), new TypeReference<List<Map<String, String>>>() {
            });
            fahrzeuge.forEach(fahrzeugMap -> {
                Motorleistung motorleistung = motorleistungRepository.findByMotorID(fahrzeugMap.get("motorleistungID")).orElseThrow();
                Fahrzeuge fahrzeug = new Fahrzeuge();
                fahrzeug.setModell(fahrzeugMap.get("modell"));
                fahrzeug.setMotorleistung(motorleistung);
                fahrzeugeRepository.save(fahrzeug);
            });*/


            System.out.println("Daten wurden aus externen Dateien initialisiert");
        };


        }
    }
