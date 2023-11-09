package com.example.mebelsite.model.repository;

import com.example.mebelsite.model.entity.NewsItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsItemRepository extends JpaRepository<NewsItemEntity, Long> {
}
