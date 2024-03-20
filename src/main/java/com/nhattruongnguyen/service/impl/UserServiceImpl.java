package com.nhattruongnguyen.service.impl;

import com.nhattruongnguyen.config.security.SecurityContextUtils;
import com.nhattruongnguyen.converter.RoleConverter;
import com.nhattruongnguyen.converter.UserConverter;
import com.nhattruongnguyen.converter.request.ChangePasswordRequestDTO;
import com.nhattruongnguyen.converter.request.UserProfileSaveRequestConverter;
import com.nhattruongnguyen.dto.UserDTO;
import com.nhattruongnguyen.dto.request.UserProfileSaveRequestDTO;
import com.nhattruongnguyen.entity.UserEntity;
import com.nhattruongnguyen.exception.StorageException;
import com.nhattruongnguyen.repository.UserRepository;
import com.nhattruongnguyen.service.StorageService;
import com.nhattruongnguyen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private RoleConverter roleConverter;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserProfileSaveRequestConverter userProfileSaveRequestConverter;
    @Autowired
    private StorageService storageService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SecurityContextUtils securityContextUtils;

    @Override
    public UserDTO findOneByEmailAndActive(String email, Integer active) {
        return userConverter.toDTO(userRepository.findOneByEmailAndActive(email, active));
    }

    @Override
    public boolean saveUserProfile(UserProfileSaveRequestDTO dto) {
        UserEntity entity = userProfileSaveRequestConverter.toEntity(dto);

        if (entity == null) {
            return false;
        }

        String currentAvatar = entity.getAvatar();

        try {
            if (!dto.getAvatarFile().isEmpty()) {
                String newAvatar = storageService.store(dto.getAvatarFile(), "avatars");
                entity.setAvatar(newAvatar);
            }
        } catch (StorageException ex) {
            entity.setAvatar(currentAvatar);
        }

        return  userRepository.save(entity) != null;
    }

    @Override
    public boolean changePassword(ChangePasswordRequestDTO dto) {
        String userLoginEmail = securityContextUtils.getUserLogin().getEmail();
        UserEntity userEntity = userRepository.findOneByEmailAndActive(userLoginEmail, 1);

        boolean isOldPasswordCorrect = passwordEncoder.matches(dto.getOldPassword(), userEntity.getPassword());

        if (isOldPasswordCorrect) {
            if (dto.getNewPassword().equals(dto.getConfirmPassword())) {
                userEntity.setPassword(passwordEncoder.encode(dto.getNewPassword()));
                return userRepository.save(userEntity) != null;
            }
        }

        return false;
    }
}
