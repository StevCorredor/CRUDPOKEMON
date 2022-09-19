package com.crud.crud.repository;

import com.crud.crud.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository <Pokemon, Long>{
}
