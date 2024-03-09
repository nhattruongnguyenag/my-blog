package com.nhattruongnguyen.converter.response;

import com.nhattruongnguyen.converter.AbstractConverter;
import com.nhattruongnguyen.dto.response.CategoryResponseDTO;
import com.nhattruongnguyen.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryResponseConverter extends AbstractConverter<CategoryEntity, CategoryResponseDTO> {
    @Override
    public CategoryResponseDTO toDTO(CategoryEntity entity) {
        CategoryResponseDTO dto = super.toDTO(entity);
        if (entity != null && entity.getPosts() != null && entity.getPosts().size() > 0) {
            dto.setPostCount(entity.getPosts().size());
        }
        return dto;
    }
}
