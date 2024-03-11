package com.example.carconfigurator.car.motorleistung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/motorleistungen")
public class MotorleistungController {

    private  final MotorleistungService motorleistungService;
    @Autowired
    public MotorleistungController(MotorleistungService motorleistungService) {
        this.motorleistungService = motorleistungService;
    }


    @GetMapping
    public List <Motorleistung> getMotorleistung(){
        return motorleistungService.getMotorleistung();
    }


}
