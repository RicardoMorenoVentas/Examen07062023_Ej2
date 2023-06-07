package com.example.examen07062023_ej2.modelo.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lugares")
public class Lugar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLugar;

    @Column(length = 60)
    private String nombre;
}
