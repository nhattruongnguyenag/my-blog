package com.nhattruongnguyen.service;

import com.nhattruongnguyen.dto.UserDTO;

public interface UserService {
    UserDTO findOneByEmailAndActive(String email, Integer active);
}
