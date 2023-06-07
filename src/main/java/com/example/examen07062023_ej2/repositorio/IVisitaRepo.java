package com.example.examen07062023_ej2.repositorio;

import com.example.examen07062023_ej2.modelo.db.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface IVisitaRepo extends JpaRepository<Visita, Integer> {
    @Query("FROM Visita v WHERE v.matricula.matricula = :matricula")
    public List<Visita> visitaPorAutobus(@Param("matricula") String matricula);

    @Query("FROM Visita v WHERE v.dni = :dni")
    public List<Visita> visitaPorConductor(@Param("dni") String dni);

    @Query("FROM Visita v WHERE v.idLugar = :idLugar")
    public List<Visita> visitaPorLugar(@Param("idLugar") int idLugar);

    @Query("FROM Visita v WHERE v.matricula = :matricula AND v.dni = :dni AND v.idLugar = :idLugar AND v.f_visita = :fecha")
    public Visita visitaPorTodosParametros(@Param("matricula") String matricula, @Param("dni") String dni, @Param("idLugar") int id_Lugar, @Param("fecha")Date fecha);

    @Query("FROM Visita v WHERE v.matricula = :matricula AND v.f_visita = :fecha")
    public List<Visita> visitaPorAutobusFecha(@Param("matricula") String matricula,@Param("fecha") Date fecha);

    @Query("FROM Visita v WHERE v.dni = :dni AND v.f_visita = :fecha")
    public List<Visita> visitaPorConductorFecha(@Param("dni") String dni,@Param("fecha") Date fecha);


    @Query("FROM Visita v WHERE v.idLugar = :idLugar AND v.f_visita = :fecha")
    public List<Visita> visitaPorLugarFecha(@Param("idLugar") int id_lugar, @Param("fecha") Date fecha);
}
