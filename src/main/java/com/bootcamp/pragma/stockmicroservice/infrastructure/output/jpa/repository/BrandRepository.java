package com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.repository;

import com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<BrandEntity, Long> {
    Optional<BrandEntity> findByName(String name);
}
