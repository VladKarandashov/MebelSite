package com.example.mebelsite.model.repository;

import com.example.mebelsite.model.entity.business.FurnitureTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurnitureTypeRepository extends JpaRepository<FurnitureTypeEntity, Long> {
    boolean existsByTitle(String title);
}
