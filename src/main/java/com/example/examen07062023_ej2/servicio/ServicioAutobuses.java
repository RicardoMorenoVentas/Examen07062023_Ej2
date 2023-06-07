package com.example.examen07062023_ej2.servicio;

import com.example.examen07062023_ej2.modelo.db.Autobus;
import com.example.examen07062023_ej2.modelo.db.Conductor;
import com.example.examen07062023_ej2.modelo.db.Lugar;
import com.example.examen07062023_ej2.modelo.db.Visita;
import com.example.examen07062023_ej2.repositorio.IAutobusRepo;
import com.example.examen07062023_ej2.repositorio.IConductorRepo;
import com.example.examen07062023_ej2.repositorio.ILugarRepo;
import com.example.examen07062023_ej2.repositorio.IVisitaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ServicioAutobuses implements IServicio {
    @Autowired
    IAutobusRepo autobusRepo;

    @Autowired
    IConductorRepo conductorRepo;

    @Autowired
    ILugarRepo lugarRepo;

    @Autowired
    IVisitaRepo visitaRepo;


    @Override
    public List<Autobus> obtenerTodosAutobuses() {
        return autobusRepo.findAll();
    }

    @Override
    public Autobus buscarAutobus(String matricula) {
        return autobusRepo.findById(matricula).get();
    }

    @Override
    public Autobus crearNuevoAutobus(Autobus bus) {
        return autobusRepo.saveAndFlush(bus);
    }

    @Override
    public List<Conductor> obtenerTodosConductores() {
        return conductorRepo.findAll();
    }

    @Override
    public Conductor buscarConductor(String dni) {
        return conductorRepo.findById(dni).get();
    }

    @Override
    public Conductor crearNuevoConductor(Conductor cond) {
        return conductorRepo.saveAndFlush(cond);
    }

    @Override
    public List<Lugar> obtenerTodosLugares() {
        return lugarRepo.findAll();
    }

    @Override
    public Lugar buscarLugar(int id_lugar) {
        return lugarRepo.findById(id_lugar).get();
    }

    @Override
    public Lugar crearNuevoLugar(Lugar lugar) {
        return lugarRepo.saveAndFlush(lugar);
    }

    @Override
    public List<Visita> obtenerTodasVisitas() {
        return visitaRepo.findAll();
    }

    @Override
    public Visita buscarVisita(int id_visita) {
        return visitaRepo.findById(id_visita).get();
    }

    @Override
    public Visita crearNuevaVisita(Visita visita) {
        return visitaRepo.saveAndFlush(visita);
    }

    @Override
    public List<Visita> buscarVisitaPorAutobus(String matricula) {
        return visitaRepo.visitaPorAutobus(matricula);
    }

    @Override
    public List<Visita> buscarVisitaPorConductor(String dni) {
        return visitaRepo.visitaPorConductor(dni);
    }

    @Override
    public List<Visita> buscarVisitaPorLugar(int id_lugar) {
        return visitaRepo.visitaPorLugar(id_lugar);
    }

    @Override
    public Visita buscarVisitaEspecifica(String matricula, String dni, int id_lugar, Date fecha) {
        return visitaRepo.visitaPorTodosParametros(matricula,dni,id_lugar,new java.sql.Date(fecha.getTime()));
    }

    @Override
    public List<Visita> buscarVisitaAutobusFecha(String matricula, Date fecha) {
        return visitaRepo.visitaPorAutobusFecha(matricula, new java.sql.Date(fecha.getTime()));
    }

    @Override
    public List<Visita> buscarVisitaConductorFecha(String dni, Date fecha) {
        return visitaRepo.visitaPorConductorFecha(dni,new java.sql.Date(fecha.getTime()));
    }

    @Override
    public List<Visita> buscarVisitaLugarFecha(int id_lugar, Date fecha) {
        return visitaRepo.visitaPorLugarFecha(id_lugar, new java.sql.Date(fecha.getTime()));
    }
}
