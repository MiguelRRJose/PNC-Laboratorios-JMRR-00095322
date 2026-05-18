package com.example.labo03.service.impl;

import com.example.labo03.domain.entity.Specimen;
import com.example.labo03.dto.request.CreateSpecimenRequest;
import com.example.labo03.dto.request.UpdateSpecimenRequest;
import com.example.labo03.dto.response.specimen.SpecimenResponse;
import com.example.labo03.exceptions.ResourceNotFoundException;
import com.example.labo03.mapper.SpecimenMapper;
import com.example.labo03.repository.SpecimenRepository;
import com.example.labo03.service.SpecimenService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SpecimenServiceImpl implements SpecimenService {

    private final SpecimenRepository specimenRepository;
    private final SpecimenMapper specimenMapper;

    @Override
    @Transactional
    public SpecimenResponse createSpecimen(CreateSpecimenRequest request) {
        return specimenMapper.toDto(
                specimenRepository.save(specimenMapper.toEntityCreate(request))
        );
    }

    @Override
    public Page<SpecimenResponse> getAllSpecimens(int page, int size, String sortBy, String sortOrder) {
        Sort sort = sortOrder.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Specimen> specimens = specimenRepository.findAll(pageable);

        if (specimens.isEmpty())
            throw new ResourceNotFoundException("No specimens are registered in Hyrule");

        return specimenMapper.toDtoPage(specimens);
    }

    @Override
    public SpecimenResponse getSpecimenById(UUID id) {
        return specimenMapper.toDto(specimenRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Specimen not found in Hyrule Records"))
        );
    }

    @Override
    @Transactional
    public SpecimenResponse updateSpecimen(UUID id, UpdateSpecimenRequest request) {
        this.getSpecimenById(id);
        return specimenMapper.toDto(
                specimenRepository.save(specimenMapper.toEntityUpdate(request, id))
        );
    }

    @Override
    @Transactional
    public SpecimenResponse deleteSpecimen(UUID id) {
        SpecimenResponse existSpecimen = this.getSpecimenById(id);
        specimenRepository.deleteById(id);
        return existSpecimen;
    }
}