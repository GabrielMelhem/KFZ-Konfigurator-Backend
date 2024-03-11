package com.example.carconfigurator.car.felgen;

import jakarta.persistence.*;

@Entity
@Table
public class Felgen {
    @Id
    @SequenceGenerator(
            name = "felgen_sequence",
            sequenceName = "felgen_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "felgen_sequence"
    )

    private Long felgenID;

    private String felgen_typ;

    private double preis;

    public Felgen() {
    }

    public Felgen(String felgen_typ, double preis) {
        this.felgen_typ = felgen_typ;
        this.preis = preis;
    }

    public Long getId() {
        return felgenID;
    }

    public void setId(Long felgenID) {
        this.felgenID = felgenID;
    }

    public String getFelgen_typ() {
        return felgen_typ;
    }

    public void setFelgen_typ(String felgen_typ) {
        if (felgen_typ != null) {
            this.felgen_typ = felgen_typ.trim();
        } else {
            throw new IllegalArgumentException("Felgen_typ darf nicht null sein");
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
