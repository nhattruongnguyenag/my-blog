package com.nhattruongnguyen.converter.response;

import com.nhattruongnguyen.converter.AbstractConverter;
import com.nhattruongnguyen.dto.response.PostEditResponseDTO;
import com.nhattruongnguyen.entity.PostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PostEditResponseConverter extends AbstractConverter<PostEntity, PostEditResponseDTO> {
    @Autowired
    private CategoryEditResponseConverter categoryEditResponseConverter;
    @Override
    public PostEditResponseDTO toDTO(PostEntity entity) {
        PostEditResponseDTO dto = super.toDTO(entity);

        if (dto == null) {
            return null;
        }

        dto.setCategoryIds(entity.getCategories().stream().map(category -> category.getId()).collect(Collectors.toList()));
        return dto;
    }
}
