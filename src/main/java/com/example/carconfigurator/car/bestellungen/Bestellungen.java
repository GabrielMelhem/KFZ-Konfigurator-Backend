package com.example.carconfigurator.car.bestellungen;

import com.example.carconfigurator.car.fahrzeuge.Fahrzeuge;
import com.example.carconfigurator.car.felgen.Felgen;
import com.example.carconfigurator.car.lackierung.Lackierung;
import com.example.carconfigurator.car.motorleistung.Motorleistung;
import com.example.carconfigurator.car.sonderausstattungen.Sonderausstattungen;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="bestellungen")
public class Bestellungen {
    @Id
    @SequenceGenerator(
            name = "bestellungen_sequence",
            sequenceName = "bestellungen_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bestellungen_sequence"
    )
    @Column(
            name = "bestellung_id",
            updatable = false
    )
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "fahrzeug_id",
            nullable = false,
            referencedColumnName = "fahrzeug_id",
            foreignKey = @ForeignKey(
                    name = "bestellung_fahrzeug_fk"
            )
    )
    private Fahrzeuge fahrzeug;

    @ManyToOne
    @JoinColumn(
            name = "motorleistung_id",
            nullable = false,
            referencedColumnName = "motorleistung_id",
            foreignKey = @ForeignKey(
                    name = "bestellung_motorleistung_fk"
            )
    )
    private Motorleistung motorleistung;

    @ManyToOne
    @JoinColumn(
            name = "felgen_id",
            nullable = false,
            referencedColumnName = "felgen_id",
            foreignKey = @ForeignKey(
                    name = "bestellung_felgen_fk"
            )
    )
    private Felgen felgen;

    @ManyToOne
    @JoinColumn(
            name = "lackierung_id",
            nullable = false,
            referencedColumnName = "lackierung_id",
            foreignKey = @ForeignKey(
                    name = "bestellung_lackierung_fk"
            )
    )
    private Lackierung lackierung;


    @ManyToMany
    @JoinTable(
            name = "bestellungen_sonderausstattungen",
            joinColumns = @JoinColumn(name = "bestellung_id",referencedColumnName = "bestellung_id"),
            inverseJoinColumns = @JoinColumn(name = "sonderausstattung_id",referencedColumnName = "sonderausstattung_id")
    )
    private Set<Sonderausstattungen> sonderausstattungen = new HashSet<Sonderausstattungen>();

    private double gesamtpreis;
    private String date;

    @Column(unique = true)
    private String urlSlug;

    public Bestellungen() {
    }

    public Bestellungen(Fahrzeuge fahrzeug, Motorleistung motorleistung, Felgen felgen, Lackierung lackierung, Set<Sonderausstattungen> sonderausstattungen, double gesamtpreis, String date, String urlSlug) {
        this.fahrzeug = fahrzeug;
        this.motorleistung = motorleistung;
        this.felgen = felgen;
        this.lackierung = lackierung;
        this.sonderausstattungen = sonderausstattungen;
        this.gesamtpreis = gesamtpreis;
        this.date = date;
        this.urlSlug = urlSlug;
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
        if (sonderausstattungen != null) {
            this.sonderausstattungen = sonderausstattungen;
        } else {
            throw new IllegalArgumentException("sonderausstattungen darf nicht null sein");
        }
    }

    public double getGesamtpreis() {
        return gesamtpreis;
    }

    public void setGesamtpreis(double gesamtpreis) {
        if (gesamtpreis > 0) {
            this.gesamtpreis = gesamtpreis;
        } else {
            throw new IllegalArgumentException("gesamtpreis darf nicht null sein");
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        if (date != null) {
            this.date = date;
        } else {
            throw new IllegalArgumentException("date darf nicht null sein");
        }
    }

    public String getUrlSlug() {
        return urlSlug;
    }

    public void setUrlSlug(String urlSlug) {
        if (urlSlug != null) {
            this.urlSlug = urlSlug;
        } else {
            throw new IllegalArgumentException("URL darf nicht null sein");
        }

    }
}
