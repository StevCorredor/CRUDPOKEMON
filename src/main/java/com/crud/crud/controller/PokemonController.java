package com.crud.crud.controller;

import com.crud.crud.entity.Pokemon;
import com.crud.crud.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @PostMapping("/Pokemon")
    public void crearPokemon(@RequestBody Pokemon Pokemon){
        pokemonService.crearYActualizarPokemon(Pokemon);
    }

    @GetMapping("/Pokemon")
    private List<Pokemon> verPokemon(){
        return pokemonService.verPokemon();
    }

    @DeleteMapping("/Pokemon/{id}")
    private void eliminarPokemon(@PathVariable("id")long id){
        pokemonService.eliminarPokemon(id);
    }

    @PutMapping("/Pokemon")
    private void editarPokemon(@RequestBody Pokemon Pokemon){
        pokemonService.crearYActualizarPokemon(Pokemon);
    }
}
