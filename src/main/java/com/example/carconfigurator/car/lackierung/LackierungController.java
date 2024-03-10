package com.example.carconfigurator.car.lackierung;

import com.example.carconfigurator.car.fahrzeuge.Fahrzeuge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/lackierungen")
public class LackierungController {

    private final LackierungService lackierungService;

    public LackierungController(LackierungService lackierungService) {
        this.lackierungService = lackierungService;
    }

    @GetMapping
    public List<Lackierung> getLackierungen(){return lackierungService.getLackierungen();}
}
