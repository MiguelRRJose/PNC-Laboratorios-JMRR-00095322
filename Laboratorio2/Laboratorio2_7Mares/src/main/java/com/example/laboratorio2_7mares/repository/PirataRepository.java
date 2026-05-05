package com.example.laboratorio2_7mares.repository;

import com.example.laboratorio2_7mares.domain.entity.Pirata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PirataRepository extends JpaRepository<Pirata, UUID> {
}