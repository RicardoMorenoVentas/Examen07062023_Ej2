package com.example.examen07062023_ej2.controlador;

import com.example.examen07062023_ej2.modelo.db.Autobus;
import com.example.examen07062023_ej2.modelo.db.Conductor;
import com.example.examen07062023_ej2.modelo.db.Lugar;
import com.example.examen07062023_ej2.modelo.db.Visita;
import com.example.examen07062023_ej2.servicio.IServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/")
public class APIController {
    @Autowired
    IServicio servicio;

    @GetMapping("/Buses")
    public List<EntityModel> getBuses(){
        List<Autobus> buses = servicio.obtenerTodosAutobuses();
        List<EntityModel> modelsOut = new ArrayList<>();
        for (Autobus b : buses) {
            WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getOneBus(b.getMatricula()));
            modelsOut.add(EntityModel.of(b).add(link.withRel("link-bus")));
        }
        return modelsOut;
    }

    @GetMapping("/getOneBus/{matricula}")
    public EntityModel<Autobus> getOneBus(@PathVariable("matricula") String matricula){
        Autobus auto_out = servicio.buscarAutobus(matricula);
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getOneBus(matricula));
        return EntityModel.of(auto_out).add(link.withRel("link-bus"));
    }

    @PostMapping("/newBus")
    public EntityModel<Autobus> postNewBus(@RequestBody Autobus bus){
        Autobus newBus = servicio.crearNuevoAutobus(bus);
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getOneBus(newBus.getMatricula()));
        return EntityModel.of(newBus).add(link.withRel("link-bus"));
    }

    @GetMapping("/Conductores")
    public List<EntityModel> getConductores(){
        List<Conductor> conductores = servicio.obtenerTodosConductores();
        List<EntityModel> modelsOut = new ArrayList<>();
        for (Conductor c : conductores) {
            WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getOneConductor(c.getDni()));
            modelsOut.add(EntityModel.of(c).add(link.withRel("link-conductor")));
        }
        return modelsOut;
    }

    @GetMapping("/getOneConductor/{dni}")
    public EntityModel<Conductor> getOneConductor(@PathVariable("dni") String dni){
        Conductor cond_out = servicio.buscarConductor(dni);
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getOneConductor(dni));
        return EntityModel.of(cond_out).add(link.withRel("link-conductor"));
    }

    @PostMapping("/newConductor")
    public EntityModel<Conductor> postNewConductor(@RequestBody Conductor cond){
        Conductor cond_out = servicio.crearNuevoConductor(cond);
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getOneConductor(cond_out.getDni()));
        return EntityModel.of(cond_out).add(link.withRel("link-conductor"));
    }

    @GetMapping("/Lugares")
    public List<EntityModel> getLugares(){
        List<Lugar> lugares = servicio.obtenerTodosLugares();
        List<EntityModel> modelsOut = new ArrayList<>();
        for (Lugar l : lugares) {
            WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getOneLugar(l.getId_lugar()));
            modelsOut.add(EntityModel.of(l).add(link.withRel("link-conductor")));
        }
        return modelsOut;
    }

    @GetMapping("/getOneLugar/{idLugar}")
    public EntityModel<Lugar> getOneLugar(@PathVariable("idLugar") int idLugar){
        Lugar lugar_out = servicio.buscarLugar(idLugar);
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getOneLugar(idLugar));
        return EntityModel.of(lugar_out).add(link.withRel("link-conductor"));
    }

    @PostMapping("/newLugar")
    public EntityModel<Lugar> postNewLugar(@RequestBody Lugar lugar){
        Lugar lugar_out = servicio.crearNuevoLugar(lugar);
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getOneLugar(lugar_out.getId_lugar()));
        return EntityModel.of(lugar_out).add(link.withRel("link-conductor"));
    }


    @GetMapping("/Visitas")
    public List<EntityModel> getVisitas(){
        List<Visita> visitas = servicio.obtenerTodasVisitas();
        List<EntityModel> modelsOut = new ArrayList<>();
        for (Visita v : visitas) {
            WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getOneVisita(v.getId()));
            modelsOut.add(EntityModel.of(v).add(link.withRel("link-conductor")));
        }
        return modelsOut;
    }

    @GetMapping("/getOneVisita/{idVisita}")
    public EntityModel<Visita> getOneVisita(@PathVariable("idVisita") int idVisita){
        Visita visita_out = servicio.buscarVisita(idVisita);
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getOneVisita(idVisita));
        return EntityModel.of(visita_out).add(link.withRel("link-conductor"));
    }

    @PostMapping("/newVisita")
    public EntityModel<Visita> postNewVisita(@RequestBody Visita visita){
        Visita visita_out = servicio.crearNuevaVisita(visita);
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getOneVisita(visita_out.getId()));
        return EntityModel.of(visita_out).add(link.withRel("link-conductor"));
    }



}
