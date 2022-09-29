package com.crud.crud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

@Table(name = "Entrenador")
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idEntrenador", nullable = false)
    private Long idEntrenador;

    private String nombre;
    private String apellido;
    private String direccion;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pokemonEntrenador", referencedColumnName = "idEntrenador")
    private List<Pokemon> pokemons = new ArrayList<>();

    /*RELACIÓN UNO A UNO
    @OneToOne (mappedBy = "entrenador")
    private Pokemon pokemon;*/

//    RELACIÓN UNO A MUCHOS
//    @OneToMany(mappedBy = "entrenador")
//    private List <Pokemon> pokemons;

//    @ManyToMany(mappedBy = "entrenadors")
//    private List<Pokemon> pokemons;
}
