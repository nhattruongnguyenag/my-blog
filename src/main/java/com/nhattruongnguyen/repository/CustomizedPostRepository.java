package com.nhattruongnguyen.repository;

import com.nhattruongnguyen.entity.PostEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface CustomizedPostRepository {
    Page<PostEntity> findByConditions(Map<String, Object> params, Pageable pageable);
}
