package com.crud.crud.entity;

import com.crud.crud.enums.Enum_Tipo;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@Data - Reemplaza los Getter y Setter
@ToString


@Table(name = "Pokemon")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long idPokemon;

    private String nombre;
    private int vida;
    private int ataque;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private Enum_Tipo tipo;

    /* RELACIÓN UNO A UNO
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;*/

    /*@ManyToOne
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;*/

//    @ManyToMany - Ojo. cambio más reciente
//    @JoinTable(name = "entrenador_pokemon")
//    private List<Entrenador> entrenadors;
}
