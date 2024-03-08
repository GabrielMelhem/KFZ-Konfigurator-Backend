package com.example.carconfigurator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Motorleistung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String leistung;
    private double preis;


    public Motorleistung() {
    }

    public Motorleistung(String leistung, double preis) {
        this.leistung = leistung;
        this.preis = preis;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLeistung() {
        return leistung;
    }

    public void setLeistung(String leistung) {
        this.leistung = leistung;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }
}
