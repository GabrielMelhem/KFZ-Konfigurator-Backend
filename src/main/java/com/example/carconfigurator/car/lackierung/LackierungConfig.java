package com.example.carconfigurator.car.lackierung;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LackierungConfig {

    @Bean
    CommandLineRunner lackierungCommandLineRunner(LackierungRepository repository) {
        return args -> {
            Lackierung lack1 = new Lackierung(
                    "Black",
                    2000

            );

            Lackierung lack2 = new Lackierung(
                    "Silver",
                    1000

            );

            repository.saveAll(
                    List.of(lack1,lack2)
            );
        };
    }
}
