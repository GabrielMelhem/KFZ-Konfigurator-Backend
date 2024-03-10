package com.example.carconfigurator.car.sonderausstattungen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/sonderausstattungen")
public class SonderausstattungenController {

    private  final SonderausstattungenService sonderausstattungenService ;

    @Autowired
    public SonderausstattungenController(SonderausstattungenService sonderausstattungenService) {
        this.sonderausstattungenService = sonderausstattungenService;
    }

    @GetMapping
    public List<Sonderausstattungen> getSonderausstattungen(){
        return sonderausstattungenService.getSonderausstattungen();
    }
}
