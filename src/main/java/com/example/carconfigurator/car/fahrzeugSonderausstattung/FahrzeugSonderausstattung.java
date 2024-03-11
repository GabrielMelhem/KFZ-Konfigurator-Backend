package com.example.carconfigurator.car.fahrzeugSonderausstattung;

import com.example.carconfigurator.car.sonderausstattungen.Sonderausstattungen;
import com.example.carconfigurator.car.fahrzeuge.Fahrzeuge;
import jakarta.persistence.*;
@Entity
@Table
public class FahrzeugSonderausstattung {
    @Id
    @SequenceGenerator(
            name = "fahrzeugSonderausstattung_sequence",
            sequenceName = "fahrzeugSonderausstattung_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fahrzeugSonderausstattung_sequence"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fahrzeugId")
    private Fahrzeuge fahrzeug;

    @ManyToOne
    @JoinColumn(name = "sonderausstattungId")
    private Sonderausstattungen sonderausstattung;

    public FahrzeugSonderausstattung() {
    }

    public FahrzeugSonderausstattung(Fahrzeuge fahrzeug, Sonderausstattungen sonderausstattung) {
        this.fahrzeug = fahrzeug;
        this.sonderausstattung = sonderausstattung;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Fahrzeuge getFahrzeug() {
        return fahrzeug;
    }

    public void setFahrzeug(Fahrzeuge fahrzeug) {
        if (fahrzeug != null) {
            this.fahrzeug = fahrzeug;
        } else {
            throw new IllegalArgumentException("fahrzeug darf nicht null sein");
        }
    }

    public Sonderausstattungen getSonderausstattung() {
        return sonderausstattung;
    }

    public void setSonderausstattung(Sonderausstattungen sonderausstattung) {
        if (sonderausstattung != null) {
            this.sonderausstattung = sonderausstattung;
        } else {
            throw new IllegalArgumentException("sonderausstattung darf nicht null sein");
        }
    }
}
