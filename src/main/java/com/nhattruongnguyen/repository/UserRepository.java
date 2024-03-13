package com.nhattruongnguyen.repository;

import com.nhattruongnguyen.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findOneByEmailAndActive(String email, Integer active);
    UserEntity findOneById(Long id);
}
