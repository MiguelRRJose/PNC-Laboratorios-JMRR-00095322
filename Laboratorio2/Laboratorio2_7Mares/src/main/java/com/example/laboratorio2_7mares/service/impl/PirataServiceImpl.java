package com.example.laboratorio2_7mares.service.impl;

import com.example.laboratorio2_7mares.domain.entity.Pirata;
import com.example.laboratorio2_7mares.repository.PirataRepository;
import com.example.laboratorio2_7mares.service.PirataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PirataServiceImpl implements PirataService {

    private final PirataRepository pirataRepository;

    @Override
    public Pirata createPirata(Pirata pirata) {
        return pirataRepository.save(pirata);
    }

    @Override
    public List<Pirata> getAllPiratas() {
        return pirataRepository.findAll();
    }

    @Override
    public Pirata getPirataById(UUID id) {
        return pirataRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pirata no encontrado con id: " + id));
    }

    @Override
    public Pirata updatePirata(UUID id, Pirata pirata) {
        Pirata existing = getPirataById(id);
        existing.setName(pirata.getName());
        existing.setBounty(pirata.getBounty());
        existing.setCrew(pirata.getCrew());
        existing.setIsAlive(pirata.getIsAlive());
        return pirataRepository.save(existing);
    }

    @Override
    public void deletePirata(UUID id) {
        pirataRepository.deleteById(id);
    }
}



