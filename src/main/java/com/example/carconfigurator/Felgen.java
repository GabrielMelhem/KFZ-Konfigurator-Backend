package com.example.carconfigurator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Felgen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String felgenType;
    private double preis;

    public Felgen() {
    }

    public Felgen(String felgenType, double preis) {
        this.felgenType = felgenType;
        this.preis = preis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFelgenType() {
        return felgenType;
    }

    public void setFelgenType(String felgenType) {
        this.felgenType = felgenType;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }
}
