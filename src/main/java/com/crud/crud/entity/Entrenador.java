package com.crud.crud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre;

    /*RELACIÓN UNO A UNO
    @OneToOne (mappedBy = "entrenador")
    private Pokemon pokemon;*/

    /*RELACIÓN UNO A MUCHOS
    @OneToMany(mappedBy = "entrenador")
    private List <Pokemon> pokemons;*/

    @ManyToMany(mappedBy = "entrenadors")
    private List<Pokemon> pokemons;
}
