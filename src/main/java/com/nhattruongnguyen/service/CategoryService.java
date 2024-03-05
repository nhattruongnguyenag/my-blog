package com.nhattruongnguyen.service;

import com.nhattruongnguyen.dto.response.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDTO> findAll();
    CategoryResponseDTO findOneBySlug(String slug);
}
