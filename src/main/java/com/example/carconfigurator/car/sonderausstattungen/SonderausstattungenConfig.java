package com.example.carconfigurator.car.sonderausstattungen;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SonderausstattungenConfig {

    @Bean
    CommandLineRunner sonderausstattungenCommandLineRunner(SonderausstattungenRepository repository){
        return args -> {
            Sonderausstattungen sonderausstattungen1 = new Sonderausstattungen(
                    "Klimaanlage",
                    6000
            );

            Sonderausstattungen sonderausstattungen2 = new Sonderausstattungen(
                    "Fahrsicherheitssysteme",
                    8000
            );

            Sonderausstattungen sonderausstattungen3 = new Sonderausstattungen(
                    "Soundsystem",
                    5000
            );

            repository.saveAll(
                    List.of(sonderausstattungen1,sonderausstattungen2,sonderausstattungen3)
            );
        };
    }
}
