package com.example.mebelsite.model.repository;

import com.example.mebelsite.model.entity.business.ColorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<ColorEntity, Long> {
    boolean existsByTitle(String title);
}
