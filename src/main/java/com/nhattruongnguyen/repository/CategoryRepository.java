package com.nhattruongnguyen.repository;

import com.nhattruongnguyen.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity findOneBySlug(String slug);
    CategoryEntity findOneById(Long id);
    List<CategoryEntity> findByIdIn(List<Long> ids);
}
