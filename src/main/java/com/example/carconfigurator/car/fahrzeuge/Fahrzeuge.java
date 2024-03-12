package com.example.carconfigurator.car.fahrzeuge;

import com.example.carconfigurator.car.felgen.Felgen;
import com.example.carconfigurator.car.lackierung.Lackierung;
import com.example.carconfigurator.car.motorleistung.Motorleistung;
import com.example.carconfigurator.car.sonderausstattungen.Sonderausstattungen;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="fahrzeuge")
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
    @Column(
            name = "fahrzeug_id",
            updatable = false
    )
    private Long id;

    private String marke;
    private String modell;
    private double preis;

    @ManyToOne
    @JoinColumn(
            name = "motorleistung_id",
            nullable = false,
            referencedColumnName = "motorleistung_id",
            foreignKey = @ForeignKey(
                    name = "fahrzeug_motorleistung_fk"
            )
    )
    private Motorleistung motorleistung;

    @ManyToOne
    @JoinColumn(
            name = "felgen_id",
            nullable = false,
            referencedColumnName = "felgen_id",
            foreignKey = @ForeignKey(
                    name = "fahrzeug_felgen_fk"
            )
    )
    private Felgen felgen;

    @ManyToOne
    @JoinColumn(
            name = "lackierung_id",
            nullable = false,
            referencedColumnName = "lackierung_id",
            foreignKey = @ForeignKey(
                    name = "fahrzeug_lackierung_fk"
            )
    )
    private Lackierung lackierung;


    @ManyToMany
    @JoinTable(
            name = "fahrzeuge_sonderausstattungen",
            joinColumns = @JoinColumn(name = "fahrzeug_id",referencedColumnName = "fahrzeug_id"),
            inverseJoinColumns = @JoinColumn(name = "sonderausstattung_id",referencedColumnName = "sonderausstattung_id")
    )
    private Set<Sonderausstattungen> sonderausstattungen = new HashSet<Sonderausstattungen>();

    public Fahrzeuge() {
    }

    public Fahrzeuge(String marke, String modell, double preis, Motorleistung motorleistung, Felgen felgen, Lackierung lackierung, Set<Sonderausstattungen> sonderausstattungen) {
        this.marke = marke;
        this.modell = modell;
        this.preis = preis;
        this.motorleistung = motorleistung;
        this.felgen = felgen;
        this.lackierung = lackierung;
        this.sonderausstattungen = sonderausstattungen;
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

    public Motorleistung getMotorleistung() {
        return motorleistung;
    }

    public void setMotorleistung(Motorleistung motorleistung) {
        if (motorleistung != null) {
            this.motorleistung = motorleistung;
        } else {
            throw new IllegalArgumentException("motorleistung darf nicht null sein");
        }
    }

    public Felgen getFelgen() {
        return felgen;
    }

    public void setFelgen(Felgen felgen) {
        if (felgen != null) {
            this.felgen = felgen;
        } else {
            throw new IllegalArgumentException("felgen darf nicht null sein");
        }
    }

    public Lackierung getLackierung() {
        return lackierung;
    }

    public void setLackierung(Lackierung lackierung) {
        if (lackierung != null) {
            this.lackierung = lackierung;
        } else {
            throw new IllegalArgumentException("lackierung darf nicht null sein");
        }
    }

    public Set<Sonderausstattungen> getSonderausstattungen() {
        return sonderausstattungen;
    }

    public void setSonderausstattungen(Set<Sonderausstattungen> sonderausstattungen) {
        this.sonderausstattungen = sonderausstattungen;
    }
}
