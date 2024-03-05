package com.nhattruongnguyen.service.impl;

import com.nhattruongnguyen.converter.response.CategoryResponseConverter;
import com.nhattruongnguyen.dto.response.CategoryResponseDTO;
import com.nhattruongnguyen.repository.CategoryRepository;
import com.nhattruongnguyen.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryResponseConverter categoryResponseConverter;

    @Override
    public List<CategoryResponseDTO> findAll() {
        return categoryResponseConverter.toDTOGroup(categoryRepository.findAll());
    }

    @Override
    public CategoryResponseDTO findOneBySlug(String slug) {
        return categoryResponseConverter.toDTO(categoryRepository.findOneBySlug(slug));
    }
}
