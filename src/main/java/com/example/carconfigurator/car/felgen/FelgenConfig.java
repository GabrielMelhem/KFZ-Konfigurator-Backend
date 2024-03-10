package com.example.carconfigurator.car.felgen;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FelgenConfig {

    @Bean
    CommandLineRunner felgenCommandLineRunner(FelgenRepository repository) {
        return args -> {
            Felgen felgen1 = new Felgen(
                    "Pro",
                    1000
            );

            Felgen felgen2 = new Felgen(
                    "Pro S",
                    15000
            );

            Felgen felgen3 = new Felgen(
                    "Pro M",
                    2000
            );

            repository.saveAll(
                    List.of(felgen1,felgen2,felgen3)
            );
        };
    }
}
