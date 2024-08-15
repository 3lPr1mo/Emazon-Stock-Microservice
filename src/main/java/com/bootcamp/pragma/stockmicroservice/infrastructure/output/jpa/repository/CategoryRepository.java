package com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.repository;

import com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
