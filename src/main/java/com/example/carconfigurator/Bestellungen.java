package com.example.carconfigurator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bestellungen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long motorleistungId;
    private Long lackierungId;
    private Long felgenId;
    private Long sonderausstattung1Id;
    private Long sonderausstattung2Id;
    private Long sonderausstattung3Id;
    private Long sonderausstattung4Id;
    private Long sonderausstattung5Id;
    private double gesamtPreis;

    public Bestellungen() {
    }

    public Bestellungen(Long motorleistungId,
                        Long lackierungId,
                        Long felgenId,
                        Long sonderausstattung1Id,
                        Long sonderausstattung2Id,
                        Long sonderausstattung3Id,
                        Long sonderausstattung4Id,
                        Long sonderausstattung5Id,
                        double gesamtPreis) {
        this.motorleistungId = motorleistungId;
        this.lackierungId = lackierungId;
        this.felgenId = felgenId;
        this.sonderausstattung1Id = sonderausstattung1Id;
        this.sonderausstattung2Id = sonderausstattung2Id;
        this.sonderausstattung3Id = sonderausstattung3Id;
        this.sonderausstattung4Id = sonderausstattung4Id;
        this.sonderausstattung5Id = sonderausstattung5Id;
        this.gesamtPreis = gesamtPreis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMotorleistungId() {
        return motorleistungId;
    }

    public void setMotorleistungId(Long motorleistungId) {
        this.motorleistungId = motorleistungId;
    }

    public Long getLackierungId() {
        return lackierungId;
    }

    public void setLackierungId(Long lackierungId) {
        this.lackierungId = lackierungId;
    }

    public Long getFelgenId() {
        return felgenId;
    }

    public void setFelgenId(Long felgenId) {
        this.felgenId = felgenId;
    }

    public Long getSonderausstattung1Id() {
        return sonderausstattung1Id;
    }

    public void setSonderausstattung1Id(Long sonderausstattung1Id) {
        this.sonderausstattung1Id = sonderausstattung1Id;
    }

    public Long getSonderausstattung2Id() {
        return sonderausstattung2Id;
    }

    public void setSonderausstattung2Id(Long sonderausstattung2Id) {
        this.sonderausstattung2Id = sonderausstattung2Id;
    }

    public Long getSonderausstattung3Id() {
        return sonderausstattung3Id;
    }

    public void setSonderausstattung3Id(Long sonderausstattung3Id) {
        this.sonderausstattung3Id = sonderausstattung3Id;
    }

    public Long getSonderausstattung4Id() {
        return sonderausstattung4Id;
    }

    public void setSonderausstattung4Id(Long sonderausstattung4Id) {
        this.sonderausstattung4Id = sonderausstattung4Id;
    }

    public Long getSonderausstattung5Id() {
        return sonderausstattung5Id;
    }

    public void setSonderausstattung5Id(Long sonderausstattung5Id) {
        this.sonderausstattung5Id = sonderausstattung5Id;
    }

    public double getGesamtPreis() {
        return gesamtPreis;
    }

    public void setGesamtPreis(double gesamtPreis) {
        this.gesamtPreis = gesamtPreis;
    }

    
}
