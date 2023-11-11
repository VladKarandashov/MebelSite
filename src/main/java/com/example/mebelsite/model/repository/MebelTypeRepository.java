package com.example.mebelsite.model.repository;

import com.example.mebelsite.model.entity.business.MebelTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MebelTypeRepository extends JpaRepository<MebelTypeEntity, Long> {
    boolean existsByTitle(String title);
}
