package com.nhattruongnguyen.converter.response;

import com.nhattruongnguyen.converter.AbstractConverter;
import com.nhattruongnguyen.dto.response.PostResponseDTO;
import com.nhattruongnguyen.entity.PostEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PostSearchResponseConverter extends AbstractConverter<PostEntity, PostResponseDTO> {
    @Override
    public PostResponseDTO toDTO(PostEntity entity) {
        PostResponseDTO dto = super.toDTO(entity);
        if (entity.getCategories() != null) {
            String categories = entity.getCategories().stream().map(categoryEntity -> categoryEntity.getName()).collect(Collectors.joining(", "));
            dto.setCategories(categories);
        }
        return dto;
    }
}
