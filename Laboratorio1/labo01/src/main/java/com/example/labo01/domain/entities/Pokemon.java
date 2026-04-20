package com.example.labo01.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pokemon {
    private String nombre;
    private String tipo;
    private List<String> debilidades;
    private List<String> zonas;
    private String region;
}