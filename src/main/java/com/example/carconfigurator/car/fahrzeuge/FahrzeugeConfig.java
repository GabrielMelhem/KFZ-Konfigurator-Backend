package com.example.carconfigurator.car.fahrzeuge;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FahrzeugeConfig {
    @Bean
    CommandLineRunner commandLineRunner(FahrzeugeRepository repository) {
        return args -> {
            Fahrzeuge fahrzeuge1 = new Fahrzeuge(
                    "Volkswagen",
                    "Der Polo",
                    21590

            );

            Fahrzeuge fahrzeuge2 = new Fahrzeuge(
                    "Mercedes",
                    "G Klass",
                    65000

            );

            repository.saveAll(
                    List.of(fahrzeuge1,fahrzeuge2)
            );
        };
    }
}
