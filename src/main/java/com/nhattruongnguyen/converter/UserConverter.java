package com.nhattruongnguyen.converter;

import com.nhattruongnguyen.dto.UserDTO;
import com.nhattruongnguyen.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends AbstractConverter<UserEntity, UserDTO>{
    @Autowired
    private RoleConverter roleConverter;
    @Override
    public UserDTO toDTO(UserEntity entity) {
        UserDTO userDTO = super.toDTO(entity);
        if (userDTO != null) {
            userDTO.setRoles(roleConverter.toDTOGroup(entity.getRoles()));
        }
        return userDTO;
    }
}
