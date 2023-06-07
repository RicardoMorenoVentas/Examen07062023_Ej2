package com.example.examen07062023_ej2.servicio;

import com.example.examen07062023_ej2.modelo.db.Autobus;
import com.example.examen07062023_ej2.modelo.db.Conductor;
import com.example.examen07062023_ej2.modelo.db.Lugar;
import com.example.examen07062023_ej2.modelo.db.Visita;

import java.util.Date;
import java.util.List;

public interface IServicio {
    public List<Autobus> obtenerTodosAutobuses();
    public Autobus buscarAutobus(String matricula);

    public Autobus crearNuevoAutobus(Autobus bus);
    public List<Conductor> obtenerTodosConductores();
    public Conductor buscarConductor(String dni);
    public Conductor crearNuevoConductor(Conductor cond);
    public List<Lugar> obtenerTodosLugares();
    public Lugar buscarLugar(int id_lugar);
    public Lugar crearNuevoLugar(Lugar lugar);
    public List<Visita> obtenerTodasVisitas();
    public Visita buscarVisita(int id_visita);

    public Visita crearNuevaVisita(Visita visita);
    public List<Visita> buscarVisitaPorAutobus(String matricula);
    public List<Visita> buscarVisitaPorConductor(String dni);
    public List<Visita> buscarVisitaPorLugar(int id_lugar);
    public Visita buscarVisitaEspecifica(String matricula, String dni, int id_lugar, Date fecha);
    public List<Visita> buscarVisitaAutobusFecha(String matricula, Date fecha);
    public List<Visita> buscarVisitaConductorFecha(String dni, Date fecha);
    public List<Visita> buscarVisitaLugarFecha(int id_lugar, Date fecha);

}
