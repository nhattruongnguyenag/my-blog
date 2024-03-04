package com.nhattruongnguyen.repository;

import com.nhattruongnguyen.entity.CategoryEntity;
import com.nhattruongnguyen.entity.PostEntity;

import java.util.List;
import java.util.Map;

public interface CustomizedCategoryRepository {
    List<CategoryEntity> findByConditions(Map<String, Object> params);
}
