package com.example.laboratorio2_7mares.controller;

import com.example.laboratorio2_7mares.domain.entity.Pirata;
import com.example.laboratorio2_7mares.service.impl.PirataServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pirates")
@RequiredArgsConstructor
public class PirataController {

    private final PirataServiceImpl pirataService;

    @PostMapping
    public ResponseEntity<Pirata> createPirata(@RequestBody Pirata pirata) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pirataService.createPirata(pirata));
    }

    @GetMapping
    public ResponseEntity<List<Pirata>> getAllPiratas() {
        return ResponseEntity.ok(pirataService.getAllPiratas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pirata> getPirataById(@PathVariable UUID id) {
        return ResponseEntity.ok(pirataService.getPirataById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pirata> updatePirata(@PathVariable UUID id, @RequestBody Pirata pirata) {
        return ResponseEntity.ok(pirataService.updatePirata(id, pirata));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePirata(@PathVariable UUID id) {
        pirataService.deletePirata(id);
        return ResponseEntity.noContent().build();
    }
}
