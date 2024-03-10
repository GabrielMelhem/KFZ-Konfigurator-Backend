package com.example.carconfigurator.car;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MotorleistungConfig {

    @Bean
    CommandLineRunner commandLineRunner(MotorleistungRepository repository) {
        return args -> {
            Motorleistung pro = new Motorleistung(
                    "Pro",
                    "100KW",
                    10000
            );

            Motorleistung pro_s = new Motorleistung(
                    "Pro S",
                    "150KW",
                    15000
            );

            repository.saveAll(
                    List.of(pro,pro_s)
            );
        };
    }
}
