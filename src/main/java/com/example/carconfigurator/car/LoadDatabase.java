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

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


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


            Resource resource = new ClassPathResource("data/fahrzeuge.json");
            try {
            List<Map<String, Object>> fahrzeuge = mapper.readValue(resource.getInputStream(), new TypeReference<List<Map<String, Object>>>() {});
            fahrzeuge.forEach(fahrzeugMap -> {
                Motorleistung motorleistung = motorleistungRepository.findById(((Integer) fahrzeugMap.get("motorleistung_id")).longValue()).orElseThrow();
                Felgen felgen = felgenRepository.findById(Long.valueOf(fahrzeugMap.get("felgen_id").toString())).orElseThrow();
                Lackierung lackierung = lackierungRepository.findById(((Integer) fahrzeugMap.get("lackierung_id")).longValue()).orElseThrow();

                List<Integer> sonderausstattungenIds = mapper.convertValue(fahrzeugMap.get("sonderausstattungen_ids"), new TypeReference<List<Integer>>() {});
                Set<Sonderausstattungen> sonderausstattungenSet = sonderausstattungenIds.stream()
                        .map(id -> sonderausstattungenRepository.findById(Long.valueOf(id)).orElseThrow())
                        .collect(Collectors.toSet());


                Fahrzeuge fahrzeug = new Fahrzeuge();
                fahrzeug.setMarke((String) fahrzeugMap.get("marke"));
                fahrzeug.setModell((String) fahrzeugMap.get("modell"));
                fahrzeug.setPreis(Double.parseDouble(fahrzeugMap.get("preis").toString()));
                fahrzeug.setMotorleistung(motorleistung);
                fahrzeug.setFelgen(felgen);
                fahrzeug.setLackierung(lackierung);
                fahrzeug.setSonderausstattungen(sonderausstattungenSet);

                fahrzeugeRepository.save(fahrzeug);
            });
            } catch (IOException e) {
                e.printStackTrace();
            }


            System.out.println("Daten wurden aus externen Dateien initialisiert");
        };


        }
    }
