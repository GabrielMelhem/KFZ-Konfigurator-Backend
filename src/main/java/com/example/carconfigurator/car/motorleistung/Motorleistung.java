package com.example.carconfigurator.car.motorleistung;

import jakarta.persistence.*;

@Entity
@Table
public class Motorleistung {
    @Id
    @SequenceGenerator(
            name = "motorleistung_sequence",
            sequenceName = "motorleistung_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "motorleistung_sequence"
    )
    private Long id;

    private String motor_name;
    private String leistung;
    private double preis;


    public Motorleistung() {
    }

    public Motorleistung(String motor_name, String leistung, double preis) {
        this.motor_name= motor_name;
        this.leistung = leistung;
        this.preis = preis;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotor_name() {
        return motor_name;
    }

    public void setMotor_name(String motor_name) {
        this.motor_name = motor_name;
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
