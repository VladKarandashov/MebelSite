package com.example.mebelsite.model.repository;

import com.example.mebelsite.model.entity.business.MaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<MaterialEntity, Long> {
    boolean existsByTitle(String title);
}
