package com.example.carconfigurator.car.motorleistung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorleistungService {

    private final MotorleistungRepository motorleistungRepository;

    @Autowired
    public MotorleistungService(MotorleistungRepository motorleistungRepository) {
        this.motorleistungRepository = motorleistungRepository;
    }

    public List<Motorleistung> getMotorleistung() {return motorleistungRepository.findAll();}


}
