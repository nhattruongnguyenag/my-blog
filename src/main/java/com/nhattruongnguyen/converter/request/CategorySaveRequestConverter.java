package com.nhattruongnguyen.converter.request;

import com.nhattruongnguyen.converter.AbstractConverter;
import com.nhattruongnguyen.dto.request.CategorySaveRequestDTO;
import com.nhattruongnguyen.entity.CategoryEntity;
import com.nhattruongnguyen.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategorySaveRequestConverter extends AbstractConverter<CategoryEntity, CategorySaveRequestDTO> {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryEntity toEntity(CategorySaveRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getId() == null) {
            return super.toEntity(dto);
        }

        CategoryEntity categoryEntity = categoryRepository.findOneById(dto.getId());

        if (categoryEntity == null) {
            return null;
        }

        if (dto.getName() != null && !dto.getName().isBlank()) {
            categoryEntity.setName(dto.getName());
        }

        if (dto.getSlug() != null && !dto.getSlug().isBlank()) {
            categoryEntity.setSlug(dto.getSlug());
        }

        return categoryEntity;
    }
}
