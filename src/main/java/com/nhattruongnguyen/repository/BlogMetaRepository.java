package com.nhattruongnguyen.repository;

import com.nhattruongnguyen.entity.BlogMetaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogMetaRepository extends JpaRepository<BlogMetaEntity, Long> {
}
