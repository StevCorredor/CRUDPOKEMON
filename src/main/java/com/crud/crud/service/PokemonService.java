package com.crud.crud.service;

import com.crud.crud.entity.Pokemon;
import com.crud.crud.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {

    @Autowired
    PokemonRepository pokemonRepository;

    public void crearYActualizarPokemon(Pokemon Pokemon){
        pokemonRepository.save(Pokemon);
    }

    public List<Pokemon> verPokemon(){
        List<Pokemon> pokemons = new ArrayList<Pokemon>();
        pokemons.addAll(pokemonRepository.findAll());
        return pokemons;
    }

    public void eliminarPokemon(Long id){
        pokemonRepository.deleteById(id);
    }

}
