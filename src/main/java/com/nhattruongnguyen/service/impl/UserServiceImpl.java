package com.nhattruongnguyen.service.impl;

import com.nhattruongnguyen.converter.RoleConverter;
import com.nhattruongnguyen.converter.UserConverter;
import com.nhattruongnguyen.dto.UserDTO;
import com.nhattruongnguyen.entity.UserEntity;
import com.nhattruongnguyen.repository.UserRepository;
import com.nhattruongnguyen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private RoleConverter roleConverter;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO findOneByEmailAndActive(String email, Integer active) {
        return userConverter.toDTO(userRepository.findOneByEmailAndActive(email, active));
    }
}
