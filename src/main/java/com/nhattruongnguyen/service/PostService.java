package com.nhattruongnguyen.service;

import com.nhattruongnguyen.dto.request.PostSaveRequestDTO;
import com.nhattruongnguyen.dto.response.PostDetailsResponseDTO;
import com.nhattruongnguyen.dto.response.PostEditResponseDTO;
import com.nhattruongnguyen.dto.response.PostResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface PostService {
    Page<PostResponseDTO> findByConditions(Map<String, Object> params, Pageable pageable);
    PostDetailsResponseDTO findPostBySlug(String slug);
    PostEditResponseDTO findPostEditById(Long postId);
    List<PostResponseDTO> findPaginated(Pageable pageable);
    boolean like(String slug);
    Long saveOrUpdate(PostSaveRequestDTO dto);
}
