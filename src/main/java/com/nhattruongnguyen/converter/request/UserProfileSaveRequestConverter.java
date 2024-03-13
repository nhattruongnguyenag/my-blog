package com.nhattruongnguyen.converter.request;

import com.nhattruongnguyen.converter.AbstractConverter;
import com.nhattruongnguyen.dto.request.UserProfileSaveRequestDTO;
import com.nhattruongnguyen.entity.UserEntity;
import com.nhattruongnguyen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserProfileSaveRequestConverter extends AbstractConverter<UserEntity, UserProfileSaveRequestDTO> {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserEntity toEntity(UserProfileSaveRequestDTO dto) {
        UserEntity entity = userRepository.findOneById(dto.getId());

        if (entity == null) {
            return null;
        }

        if (dto.getEmail() != null && !dto.getEmail().isBlank()) {
            entity.setEmail(dto.getEmail());
        }

        if (dto.getName() != null && !dto.getName().isBlank()) {
            entity.setName(dto.getName());
        }

        return entity;
    }
}
