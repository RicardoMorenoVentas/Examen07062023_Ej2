package com.example.examen07062023_ej2.modelo.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "autobuses")
public class Autobus {
    @Id
    @Column(length = 7)
    private String matricula;

    private int a_fabricacion;
}
