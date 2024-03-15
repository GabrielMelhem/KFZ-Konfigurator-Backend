package com.example.carconfigurator.car.motorleistung;


import jakarta.persistence.*;

@Entity
@Table(name = "motorleistungen")
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
    @Column(
            name="motorleistung_id",
            updatable=false
    )
    private Long id;

    private String motor_name;
    private int leistung;
    private double preis;



    public Motorleistung() {
    }

    public Motorleistung(String motor_name, int leistung, double preis) {
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
        if (motor_name != null) {
            this.motor_name = motor_name.trim();
        } else {
            throw new IllegalArgumentException("Motor_name darf nicht null sein");
        }
    }

    public int getLeistung() {
        return leistung;
    }

    public void setLeistung(int leistung) {
        if (leistung > 0) {
            this.leistung = leistung;
        } else {
            throw new IllegalArgumentException("Die Leistung muss größer als 0 sein");
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
