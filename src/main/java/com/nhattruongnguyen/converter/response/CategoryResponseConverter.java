package com.nhattruongnguyen.converter.response;

import com.nhattruongnguyen.converter.AbstractConverter;
import com.nhattruongnguyen.dto.response.CategoryResponseDTO;
import com.nhattruongnguyen.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryResponseConverter extends AbstractConverter<CategoryEntity, CategoryResponseDTO> {
}
