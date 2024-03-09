package com.nhattruongnguyen.service;

import com.nhattruongnguyen.dto.response.CategoryResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDTO> findAll();
    Page<CategoryResponseDTO> findAll(Pageable pageable);
    CategoryResponseDTO findOneBySlug(String slug);
}
