package com.example.labo03.service;

import com.example.labo03.dto.request.CreateSpecimenRequest;
import com.example.labo03.dto.request.UpdateSpecimenRequest;
import com.example.labo03.dto.response.specimen.SpecimenResponse;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface SpecimenService {
    SpecimenResponse createSpecimen(CreateSpecimenRequest request);
    Page<SpecimenResponse> getAllSpecimens(int page, int size, String sortBy, String sortOrder);
    SpecimenResponse getSpecimenById(UUID id);
    SpecimenResponse updateSpecimen(UUID id, UpdateSpecimenRequest request);
    SpecimenResponse deleteSpecimen(UUID id);
}