package com.example.laboratorio2_7mares.service;

import com.example.laboratorio2_7mares.domain.entity.Pirata;

import java.util.List;
import java.util.UUID;

public interface PirataService {
    Pirata createPirata(Pirata pirata);
    List<Pirata> getAllPiratas();
    Pirata getPirataById(UUID id);
    Pirata updatePirata(UUID id, Pirata pirata);
    void deletePirata(UUID id);
}