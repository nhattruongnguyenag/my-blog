package com.nhattruongnguyen.service;

import com.nhattruongnguyen.dto.request.CategorySaveRequestDTO;
import com.nhattruongnguyen.dto.response.CategoryResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDTO> findAll();
    Page<CategoryResponseDTO> findAll(Pageable pageable);
    CategoryResponseDTO findOneBySlug(String slug);
    CategoryResponseDTO findOneById(Long id);
    CategoryResponseDTO saveOrUpdate(CategorySaveRequestDTO categorySaveRequest);
    boolean delete(Long id);
}
