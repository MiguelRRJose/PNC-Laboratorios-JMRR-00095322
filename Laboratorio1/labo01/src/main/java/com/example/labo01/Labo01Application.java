package com.example.labo01;

import com.example.labo01.domain.entities.Pokemon;
import com.example.labo01.services.PokemonServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Labo01Application {

    public static void main(String[] args) {
        SpringApplication.run(Labo01Application.class, args);
    }

    @Bean
    public CommandLineRunner run(PokemonServices pokemonServices) {
        return args -> {
            System.out.println("=== POKÉDEX DEL PROFESOR OAK ===");

            System.out.println("\n>> Filtro por tipo: Fuego");
            imprimir(pokemonServices.filtrarPorTipo("Fuego"));

            System.out.println("\n>> Filtro por zona: Bosque");
            imprimir(pokemonServices.filtrarPorZona("Bosque"));

            System.out.println("\n>> Filtro por debilidad: Agua");
            imprimir(pokemonServices.filtrarPorDebilidad("Agua"));
        };
    }

    private void imprimir(List<Pokemon> lista) {
        lista.forEach(p ->
                System.out.println("[PKMN] Nombre: " + p.getNombre() +
                        " | Tipo: " + p.getTipo() +
                        " | Debilidades: " + String.join(", ", p.getDebilidades()))
        );
    }
}