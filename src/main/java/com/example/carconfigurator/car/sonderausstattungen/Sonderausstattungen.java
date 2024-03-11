package com.example.carconfigurator.car.sonderausstattungen;

import jakarta.persistence.*;

@Entity
@Table
public class Sonderausstattungen {
    @Id
    @SequenceGenerator(
            name = "sonderausstattungen_sequence",
            sequenceName = "sonderausstattungen_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sonderausstattungen_sequence"
    )

    private Long sonderausstattungenID;

    private String sonderausstattung_name;

    private double preis;

    public Sonderausstattungen() {
    }

    public Sonderausstattungen(String sonderausstattung_name, double preis) {
        this.sonderausstattung_name = sonderausstattung_name;
        this.preis = preis;
    }

    public Long getId() {
        return sonderausstattungenID;
    }

    public void setId(Long sonderausstattungenID) {
        this.sonderausstattungenID = sonderausstattungenID;
    }

    public String getSonderausstattung_name() {
        return sonderausstattung_name;
    }

    public void setSonderausstattung_name(String sonderausstattung_name) {
        if (sonderausstattung_name != null) {
            this.sonderausstattung_name = sonderausstattung_name.trim(); //to remove leading or trailing spaces
        } else {
            throw new IllegalArgumentException("Sonderausstattung_name darf nicht null sein");
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
