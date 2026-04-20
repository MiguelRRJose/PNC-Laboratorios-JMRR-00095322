package com.example.labo01.repositories;

import com.example.labo01.common.ListaPokemon;
import com.example.labo01.domain.entities.Pokemon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PokemonRepository {
    private final ListaPokemon listaPokemon;

    public List<Pokemon> findAll() {
        return listaPokemon.getPokemones();
    }
}