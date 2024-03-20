package com.nhattruongnguyen.repository.impl;

import com.nhattruongnguyen.entity.PostEntity;
import com.nhattruongnguyen.repository.CustomizedPostRepository;
import com.nhattruongnguyen.utils.CommonUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        buildWhereQuery(params, whereQuery);

        finalQuery.append(joinQuery);
        countQuery.append(joinQuery);
        finalQuery.append("\nWHERE 1 = 1");
        countQuery.append("\nWHERE 1 = 1");
        finalQuery.append(whereQuery);
        countQuery.append(whereQuery);

        int offset = pageable.getPageSize() * pageable.getPageNumber();

        long totalPage = entityManager.createQuery(countQuery.toString(), Long.class).getSingleResult();

        if (pageable.getSort() != null && pageable.getSort().iterator().hasNext()) {
            Sort.Order order = pageable.getSort().iterator().next();
            finalQuery.append("\nORDER BY ").append("p.").append(order.getProperty()).append(' ').append(order.getDirection().name());
        }

        List<PostEntity> posts = entityManager.createQuery(finalQuery.toString(), PostEntity.class)
                .setFirstResult(offset).setMaxResults(pageable.getPageSize())
                .getResultList();

        Page<PostEntity> page = new PageImpl<>(posts, pageable, totalPage);

        return page;
    }

    private void buildJoinQuery(Map<String, Object> params, StringBuilder joinQuery, StringBuilder whereQuery) {
        String category = CommonUtils.getParams("category", params, String.class);

        joinQuery.append("\nLEFT JOIN p.postTrash as t");

        whereQuery.append("\nAND t IS NULL");

        if (category != null) {
            joinQuery.append("\nJOIN p.categories as c");
            whereQuery.append("\nAND c.slug = ").append("'").append(category).append("'");
        }
    }

    private void buildWhereQuery(Map<String, Object> params, StringBuilder whereQuery) {
        Integer status = CommonUtils.getParams("status", params, Integer.class);
        if (status != null) {
            whereQuery.append("\nAND p.status = ").append(status);
        }
    }
}
