package com.example.carconfigurator.car.fahrzeuge;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class FahrzeugeConfig {
    @Bean
    CommandLineRunner fahrzeugeCommandLineRunner(FahrzeugeRepository repository) {
        return args -> {
            Fahrzeuge car1 = new Fahrzeuge(
                    "Volkswagen",
                    "Der Polo",
                    21590

            );

            Fahrzeuge car2 = new Fahrzeuge(
                    "Mercedes",
                    "G Klass",
                    65000

            );

            repository.saveAll(
                    List.of(car1,car2)
            );
        };
    }
}
