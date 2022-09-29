package com.crud.crud.controller;
import com.crud.crud.entity.Entrenador;
import com.crud.crud.service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntrenadorController {

    @Autowired
    EntrenadorService entrenadorService;

    @PostMapping("/Crear_Entrenador")
    public void crearEntrenador(@RequestBody Entrenador Entrenador){
        entrenadorService.crearYActualizarEntrenador(Entrenador);
    }

    @GetMapping("/Listar_Entrenador")
    private List<Entrenador> verEntrenador(){
        return entrenadorService.verEntrenador();
    }

    @DeleteMapping("/Eliminar_Entrenador/{id}")
    private void eliminarEntrenador(@PathVariable("id")long id){
        entrenadorService.eliminarEntrenador(id);
    }

    @PutMapping("/Actualizar_Entrenador")
    private void editarEntrenador(@RequestBody Entrenador Entrenador){
        entrenadorService.crearYActualizarEntrenador(Entrenador);
    }
}
