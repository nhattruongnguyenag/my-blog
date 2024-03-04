package com.nhattruongnguyen.repository;

import com.nhattruongnguyen.entity.CategoryEntity;
import com.nhattruongnguyen.entity.TagEntity;

import java.util.List;
import java.util.Map;

public interface CustomizedTagRepository {
    List<TagEntity> findByConditions(Map<String, Object> params);
}
