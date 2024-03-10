package com.nhattruongnguyen.service.impl;

import com.nhattruongnguyen.converter.request.CategorySaveRequestConverter;
import com.nhattruongnguyen.converter.response.CategoryResponseConverter;
import com.nhattruongnguyen.dto.request.CategorySaveRequestDTO;
import com.nhattruongnguyen.dto.response.CategoryResponseDTO;
import com.nhattruongnguyen.entity.CategoryEntity;
import com.nhattruongnguyen.repository.CategoryRepository;
import com.nhattruongnguyen.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryResponseConverter categoryResponseConverter;
    @Autowired
    private CategorySaveRequestConverter categorySaveRequestConverter;

    @Override
    public List<CategoryResponseDTO> findAll() {
        return categoryResponseConverter.toDTOGroup(categoryRepository.findAll());
    }

    @Override
    public Page<CategoryResponseDTO> findAll(Pageable pageable) {
        return categoryResponseConverter.toDTOPage(categoryRepository.findAll(pageable));
    }

    @Override
    public CategoryResponseDTO findOneBySlug(String slug) {
        return categoryResponseConverter.toDTO(categoryRepository.findOneBySlug(slug));
    }

    @Override
    public CategoryResponseDTO findOneById(Long id) {
        if (id == null) {
            return null;
        }

        CategoryEntity categoryEntity = categoryRepository.findOneById(id);

        if (categoryEntity == null) {
            return null;
        }

        return categoryResponseConverter.toDTO(categoryEntity);
    }

    @Override
    public CategoryResponseDTO saveOrUpdate(CategorySaveRequestDTO dto) {
        CategoryEntity categoryEntity = categorySaveRequestConverter.toEntity(dto);

        if (categoryEntity == null) {
            return null;
        }

        return categoryResponseConverter.toDTO(categoryRepository.save(categoryEntity));
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        try {
            categoryRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
