package com.example.carconfigurator.car.fahrzeuge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/fahrzeuge")
public class FahrzeugeController {

    private final FahrzeugeService fahrzeugeService;

    @Autowired
    public FahrzeugeController(FahrzeugeService fahrzeugeService) {
        this.fahrzeugeService = fahrzeugeService;
    }

    @GetMapping
    public List<Fahrzeuge> getFahrzeuge(){return fahrzeugeService.getFahrzeuge();}
}

