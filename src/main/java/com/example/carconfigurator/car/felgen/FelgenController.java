package com.example.carconfigurator.car.felgen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/felgen")
public class FelgenController {

    private final FelgenService felgenService ;

    @Autowired
    public FelgenController(FelgenService felgenService) {
        this.felgenService = felgenService;
    }

    @GetMapping
    public List<Felgen> getFelgen(){
        return felgenService.getFelgen();
    }
}
