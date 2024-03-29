package com.example.carconfigurator.car.lackierung;

import jakarta.persistence.*;

@Entity
@Table(name = "lackierungen")
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
    @Column(
            name="lackierung_id",
            updatable=false
    )
    private Long id;

    private String farbe;

    private double preis;

    public Lackierung() {
    }

    public Lackierung(String farbe, double preis) {
        this.farbe = farbe;
        this.preis = preis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
