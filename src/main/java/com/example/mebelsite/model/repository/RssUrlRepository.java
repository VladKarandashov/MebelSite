package com.example.mebelsite.model.repository;

import com.example.mebelsite.model.entity.RssUrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RssUrlRepository extends JpaRepository<RssUrlEntity, Long> {
}
