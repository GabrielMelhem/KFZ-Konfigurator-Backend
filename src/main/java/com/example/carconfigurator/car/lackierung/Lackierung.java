package com.example.carconfigurator.car.lackierung;

import jakarta.persistence.*;

@Entity
@Table
public class Lackierung {
    @Id
    @SequenceGenerator(
            name = "lackierung_sequence",
            sequenceName = "lackierung_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "lackierung_sequence"
    )
    private Long lackierungID;

    private String farbe;

    private double preis;

    public Lackierung() {
    }

    public Lackierung(String farbe, double preis) {
        this.farbe = farbe;
        this.preis = preis;
    }

    public Long getId() {
        return lackierungID;
    }

    public void setId(Long lackierungID) {
        this.lackierungID = lackierungID;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        if (farbe != null) {
            this.farbe = farbe.trim();
        } else {
            throw new IllegalArgumentException("Farbe darf nicht null sein");
        }
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        if (preis > 0) {
            this.preis = preis;
        } else {
            throw new IllegalArgumentException("Der Preis muss größer als 0 sein");
        }
    }
}
