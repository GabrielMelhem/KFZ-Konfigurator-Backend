package com.example.carconfigurator.car.felgen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FelgenService {

    private final FelgenRepository felgenRepository;

    @Autowired
    public FelgenService(FelgenRepository felgenRepository) {
        this.felgenRepository = felgenRepository;
    }

    public List<Felgen> getFelgen() {return felgenRepository.findAll();}
}
