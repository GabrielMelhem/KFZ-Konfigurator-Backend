package com.example.carconfigurator.car.fahrzeuge;

import jakarta.persistence.*;

@Entity
@Table
public class Fahrzeuge {
    @Id
    @SequenceGenerator(
            name = "fahrzeuge_sequence",
            sequenceName = "fahrzeuge_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fahrzeuge_sequence"
    )
    private Long id;

    private String marke;
    private String modell;
    private double preis;

    public Fahrzeuge() {
    }

    public Fahrzeuge(String marke, String modell, double preis) {
        this.marke = marke;
        this.modell = modell;
        this.preis = preis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        if (marke != null) {
            this.marke = marke.trim();
        } else {
            throw new IllegalArgumentException("Marke darf nicht null sein");
        }
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        if (modell != null) {
            this.modell = modell.trim();
        } else {
            throw new IllegalArgumentException("Modell darf nicht null sein");
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
