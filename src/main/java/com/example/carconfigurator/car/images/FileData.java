package com.example.carconfigurator.car.images;


import com.example.carconfigurator.car.fahrzeuge.Fahrzeuge;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "FILE_DATA")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String filePath;

    @ManyToOne
    @JoinColumn(name = "fahrzeug_id", nullable = true) // nullable = true if an image doesn't necessarily have to be linked to a Fahrzeuge
    private Fahrzeuge fahrzeuge;
}
