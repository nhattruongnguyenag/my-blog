package com.nhattruongnguyen.service.impl;

import com.nhattruongnguyen.converter.response.PostSearchResponseConverter;
import com.nhattruongnguyen.dto.response.PostSearchResponseDTO;
import com.nhattruongnguyen.entity.PostEntity;
import com.nhattruongnguyen.repository.CustomizedPostRepository;
import com.nhattruongnguyen.repository.PostRepository;
import com.nhattruongnguyen.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostSearchResponseConverter postSearchResponseConverter;
    @Autowired
    private CustomizedPostRepository customizedPostRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public Page<PostSearchResponseDTO> findByConditions(Map<String, Object> params, Pageable pageable) {
       return postSearchResponseConverter.toDTOPage(customizedPostRepository.findByConditions(params, pageable));
    }

    @Override
    public PostSearchResponseDTO findPostBySlug(String slug) {
        return postSearchResponseConverter.toDTO(postRepository.findBySlug(slug));
    }

    @Override
    public List<PostSearchResponseDTO> findPaginated(Pageable pageable) {
        Page<PostEntity> posts = postRepository.findAll(pageable);
        return postSearchResponseConverter.toDTOGroup(postRepository.findAll(pageable).getContent());
    }
}
