package com.nhattruongnguyen.service;

import com.nhattruongnguyen.converter.request.ChangePasswordRequestDTO;
import com.nhattruongnguyen.dto.UserDTO;
import com.nhattruongnguyen.dto.request.UserProfileSaveRequestDTO;

public interface UserService {
    UserDTO findOneByEmailAndActive(String email, Integer active);
    boolean saveUserProfile(UserProfileSaveRequestDTO dto);
    boolean changePassword(ChangePasswordRequestDTO dto);
}
