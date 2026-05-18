package com.example.labo03.controller;

import com.example.labo03.dto.request.CreateSpecimenRequest;
import com.example.labo03.dto.request.UpdateSpecimenRequest;
import com.example.labo03.dto.response.GeneralResponse;
import com.example.labo03.dto.response.specimen.SpecimenResponse;
import com.example.labo03.service.impl.SpecimenServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/specimens")
@RequiredArgsConstructor
public class SpecimenController {

    private final SpecimenServiceImpl specimenService;

    private ResponseEntity<GeneralResponse> buildResponse(Object data, String message, HttpStatus status, HttpServletRequest request) {
        return ResponseEntity.status(status).body(
                GeneralResponse.builder()
                        .data(data)
                        .message(message)
                        .status(status.value())
                        .timestamp(LocalDateTime.now())
                        .path(request.getRequestURI())
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<GeneralResponse> createSpecimen(
            @Valid @RequestBody CreateSpecimenRequest request,
            HttpServletRequest httpRequest) {
        SpecimenResponse response = specimenService.createSpecimen(request);
        return buildResponse(response, "Specimen registered in Sheikah Slate", HttpStatus.CREATED, httpRequest);
    }

    @GetMapping
    public ResponseEntity<GeneralResponse> getAllSpecimens(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder,
            HttpServletRequest httpRequest) {
        Page<SpecimenResponse> response = specimenService.getAllSpecimens(page, size, sortBy, sortOrder);
        return buildResponse(response, "Specimens retrieved successfully", HttpStatus.OK, httpRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneralResponse> getSpecimenById(
            @PathVariable UUID id,
            HttpServletRequest httpRequest) {
        SpecimenResponse response = specimenService.getSpecimenById(id);
        return buildResponse(response, "Specimen found in Sheikah Slate", HttpStatus.OK, httpRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneralResponse> updateSpecimen(
            @PathVariable UUID id,
            @RequestBody UpdateSpecimenRequest request,
            HttpServletRequest httpRequest) {
        SpecimenResponse response = specimenService.updateSpecimen(id, request);
        return buildResponse(response, "Specimen updated in Sheikah Slate", HttpStatus.OK, httpRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GeneralResponse> deleteSpecimen(
            @PathVariable UUID id,
            HttpServletRequest httpRequest) {
        SpecimenResponse response = specimenService.deleteSpecimen(id);
        return buildResponse(response, "Specimen removed from Sheikah Slate", HttpStatus.OK, httpRequest);
    }
}