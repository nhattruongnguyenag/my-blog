package com.nhattruongnguyen.repository;

import com.nhattruongnguyen.entity.TagEntity;
import com.nhattruongnguyen.entity.UserEntity;

import java.util.List;
import java.util.Map;

public interface CustomizedUserRepository {
    List<UserEntity> findByConditions(Map<String, Object> params);
}
