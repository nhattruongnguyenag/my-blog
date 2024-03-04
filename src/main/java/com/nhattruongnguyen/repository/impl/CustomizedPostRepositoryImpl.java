package com.nhattruongnguyen.repository.impl;

import com.nhattruongnguyen.entity.PostEntity;
import com.nhattruongnguyen.repository.CustomizedPostRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CustomizedPostRepositoryImpl implements CustomizedPostRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<PostEntity> findByConditions(Map<String, Object> params, Pageable pageable) {
        StringBuilder completeQuery = new StringBuilder("SELECT p from PostEntity p");
        StringBuilder countQuery = new StringBuilder("SELECT count(p) from PostEntity p");
        completeQuery.append("\nORDER BY p.updatedAt");

        int offset = pageable.getPageSize() * (pageable.getPageNumber() - 1);

        long totalPage = entityManager.createQuery(countQuery.toString(), Long.class).getSingleResult() / pageable.getPageSize();

        List<PostEntity> posts =  entityManager.createQuery(completeQuery.toString(), PostEntity.class)
                .setFirstResult(offset).setMaxResults(pageable.getPageSize()).getResultList();

        Page<PostEntity> page = new PageImpl<>(posts, pageable, totalPage);

        return page;
    }
}
