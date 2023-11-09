package com.example.mebelsite.model.repository;

import com.example.mebelsite.model.entity.business.FurnitureBrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurnitureBrandRepository extends JpaRepository<FurnitureBrandEntity, Long> {
}
