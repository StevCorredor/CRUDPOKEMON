package com.crud.crud.controller;

import com.crud.crud.entity.Pokemon;
import com.crud.crud.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//esta es la conexión con la parte web
@RestController
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @PostMapping("/Crear_Pokemon")
    public void crearPokemon(@RequestBody Pokemon Pokemon){
        pokemonService.crearYActualizarPokemon(Pokemon);
    }

    @GetMapping("/Listar_Pokemon")
    private List<Pokemon> verPokemon(){
        return pokemonService.verPokemon();
    }

    @DeleteMapping("/Eliminar_Pokemon/{id}")
    private void eliminarPokemon(@PathVariable("id")long id){
        pokemonService.eliminarPokemon(id);
    }

    @PutMapping("/Actualizar_Pokemon")
    private void editarPokemon(@RequestBody Pokemon Pokemon){
        pokemonService.crearYActualizarPokemon(Pokemon);
    }
}
