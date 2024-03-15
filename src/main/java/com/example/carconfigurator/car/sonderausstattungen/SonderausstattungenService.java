package com.example.carconfigurator.car.sonderausstattungen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SonderausstattungenService {

    private final SonderausstattungenRepository sonderausstattungenRepository;

    @Autowired

    public SonderausstattungenService(SonderausstattungenRepository sonderausstattungenRepository) {
        this.sonderausstattungenRepository = sonderausstattungenRepository;
    }

    public List<Sonderausstattungen> getSonderausstattungen() {return  sonderausstattungenRepository.findAll();}
}
