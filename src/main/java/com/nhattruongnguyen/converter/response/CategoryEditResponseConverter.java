package com.nhattruongnguyen.converter.response;

import com.nhattruongnguyen.converter.AbstractConverter;
import com.nhattruongnguyen.dto.response.CategoryEditResponseDTO;
import com.nhattruongnguyen.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryEditResponseConverter extends AbstractConverter<CategoryEntity, CategoryEditResponseDTO> {
}
