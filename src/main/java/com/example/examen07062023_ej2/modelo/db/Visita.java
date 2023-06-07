package com.example.examen07062023_ej2.modelo.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "visitas")
public class Visita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date f_visita;
    @ManyToOne
    @JoinColumn(name = "matricula", foreignKey = @ForeignKey(name = "FK_VISITA_AUTOBUS"))
    private Autobus matricula;

    @ManyToOne
    @JoinColumn(name = "dni", foreignKey = @ForeignKey(name="FK_VISITA_CONDUCTOR"))
    private Conductor dni;

    @ManyToOne
    @JoinColumn(name = "id_lugar", foreignKey = @ForeignKey(name = "FK_VISITA_LUGAR"))
    private Lugar id_lugar;
}
