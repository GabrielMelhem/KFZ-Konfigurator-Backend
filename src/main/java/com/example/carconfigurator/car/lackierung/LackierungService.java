package com.example.carconfigurator.car.lackierung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LackierungService {

    private final LackierungRepository lackierungRepository;

    @Autowired
    public LackierungService(LackierungRepository lackierungRepository) {
        this.lackierungRepository = lackierungRepository;
    }

    public List <Lackierung> getLackierungen() {return lackierungRepository.findAll();}
}
