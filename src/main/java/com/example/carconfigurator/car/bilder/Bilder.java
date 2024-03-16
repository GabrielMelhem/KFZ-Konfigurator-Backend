package com.example.carconfigurator.car.bilder;

import jakarta.persistence.*;

@Entity
@Table(name = "bilder")
public class Bilder {
    @Id
    @SequenceGenerator(
            name = "bild_sequence",
            sequenceName = "bild_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "bild_sequence"
    )
    @Column(
            name="bild_id",
            updatable=false
    )
    private Long id;

    private String name;
    private String type;
    private String bildPath;

    public Bilder() {
    }

    public Bilder(String name, String type, String bildPath) {
        this.name = name;
        this.type = type;
        this.bildPath = bildPath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBildPath() {
        return bildPath;
    }

    public void setBildPath(String bildPath) {
        this.bildPath = bildPath;
    }
}
