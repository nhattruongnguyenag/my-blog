package com.nhattruongnguyen.service;

import com.nhattruongnguyen.dto.response.PostSearchResponseDTO;
import com.nhattruongnguyen.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface PostService {
    Page<PostSearchResponseDTO> findByConditions(Map<String, Object> params, Pageable pageable);
    PostSearchResponseDTO findPostBySlug(String slug);
    List<PostSearchResponseDTO> findPaginated(Pageable pageable);
}
