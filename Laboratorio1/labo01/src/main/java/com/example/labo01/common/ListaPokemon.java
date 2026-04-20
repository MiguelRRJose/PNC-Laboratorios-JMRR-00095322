package com.example.labo01.common;

import com.example.labo01.domain.entities.Pokemon;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListaPokemon {
    private final List<Pokemon> pokemones;

    public ListaPokemon() {
        this.pokemones = new ArrayList<>();

        this.pokemones.add(Pokemon.builder()
                .nombre("Charmander").tipo("Fuego")
                .debilidades(List.of("Agua", "Roca", "Tierra"))
                .zonas(List.of("Cueva", "Montaña")).region("Kanto").build());

        this.pokemones.add(Pokemon.builder()
                .nombre("Squirtle").tipo("Agua")
                .debilidades(List.of("Planta", "Eléctrico"))
                .zonas(List.of("Mar", "Lago")).region("Kanto").build());

        this.pokemones.add(Pokemon.builder()
                .nombre("Waldo").tipo("Planta")
                .debilidades(List.of("Fuego", "Hielo", "Volador"))
                .zonas(List.of("Bosque", "Hierba Alta")).region("Kanto").build());

        this.pokemones.add(Pokemon.builder()
                .nombre("Pikachu").tipo("Eléctrico")
                .debilidades(List.of("Tierra"))
                .zonas(List.of("Bosque", "Hierba Alta")).region("Kanto").build());

    }

    public List<Pokemon> getPokemones() {
        return pokemones;
    }
}