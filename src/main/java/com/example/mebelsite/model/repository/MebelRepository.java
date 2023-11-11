package com.example.mebelsite.model.repository;

import com.example.mebelsite.model.entity.business.MebelEntity;
import com.example.mebelsite.model.entity.business.MebelTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MebelRepository extends JpaRepository<MebelEntity, Long> {
    @Query("SELECT id FROM MebelEntity ORDER BY id ASC LIMIT 1")
    Optional<Long> findFirstRowId();

    @Query("SELECT id FROM MebelEntity ORDER BY id DESC LIMIT 1")
    Optional<Long> findLastRowId();

    @Query("SELECT MAX(id) FROM MebelEntity WHERE id < :myId")
    Long getPreviousId(@Param("myId") Long myId);

    @Query("SELECT MIN(id) FROM MebelEntity WHERE id > :myId")
    Long getNextId(@Param("myId") Long myId);

    Long countByMebelType(MebelTypeEntity mebelType);
}
