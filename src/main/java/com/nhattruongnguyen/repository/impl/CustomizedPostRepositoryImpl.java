package com.nhattruongnguyen.repository.impl;

import com.nhattruongnguyen.entity.PostEntity;
import com.nhattruongnguyen.repository.CustomizedPostRepository;
import com.nhattruongnguyen.utils.CommonUtils;
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
        StringBuilder finalQuery = new StringBuilder("SELECT p from PostEntity p");
        StringBuilder countQuery = new StringBuilder("SELECT count(p) from PostEntity p");
        StringBuilder whereQuery = new StringBuilder();
        StringBuilder joinQuery = new StringBuilder();

        buildJoinQuery(params, joinQuery, whereQuery);

        finalQuery.append(joinQuery);
        countQuery.append(joinQuery);
        finalQuery.append("\nWHERE 1 = 1");
        countQuery.append("\nWHERE 1 = 1");
        finalQuery.append(whereQuery);
        countQuery.append(whereQuery);
        finalQuery.append("\nORDER BY p.createdAt DESC");

        int offset = pageable.getPageSize() * pageable.getPageNumber();

        long totalPage = entityManager.createQuery(countQuery.toString(), Long.class).getSingleResult();

        List<PostEntity> posts =  entityManager.createQuery(finalQuery.toString(), PostEntity.class)
                .setFirstResult(offset).setMaxResults(pageable.getPageSize()).getResultList();

        Page<PostEntity> page = new PageImpl<>(posts, pageable, totalPage);

        return page;
    }

    private void buildJoinQuery(Map<String, Object> params, StringBuilder joinQuery, StringBuilder whereQuery){
        String category = CommonUtils.getParams("category", params, String.class);

        if (category != null) {
            joinQuery.append("\nJOIN p.categories as c");
            whereQuery.append("\nAND c.slug = ").append("'").append(category).append("'");
        }
    }
}
