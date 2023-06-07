package com.example.examen07062023_ej2.modelo.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "conductores")
public class Conductor {
    @Id
    @Column(length = 10)
    private String dni;

    @Column(length = 60)
    private String nombre;
}
