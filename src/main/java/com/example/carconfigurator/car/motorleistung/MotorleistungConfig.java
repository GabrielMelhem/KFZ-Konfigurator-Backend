package com.example.carconfigurator.car.motorleistung;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MotorleistungConfig {

    @Bean
    CommandLineRunner motorleistungCommandLineRunner(MotorleistungRepository repository) {
        return args -> {
            Motorleistung pro = new Motorleistung(
                    "Pro",
                    100,
                    10000
            );

            Motorleistung pro_s = new Motorleistung(
                    "Pro S",
                    150,
                    15000
            );

            Motorleistung pro_m = new Motorleistung(
                    "Pro M",
                    200,
                    20000
            );

            repository.saveAll(
                    List.of(pro,pro_s,pro_m)
            );
        };
    }
}
