package com.nhattruongnguyen.service.impl;

import com.nhattruongnguyen.converter.request.PostSaveRequestConverter;
import com.nhattruongnguyen.converter.response.PostDetailsResponseConverter;
import com.nhattruongnguyen.converter.response.PostEditResponseConverter;
import com.nhattruongnguyen.converter.response.PostSearchResponseConverter;
import com.nhattruongnguyen.dto.request.PostSaveRequestDTO;
import com.nhattruongnguyen.dto.response.PostDetailsResponseDTO;
import com.nhattruongnguyen.dto.response.PostEditResponseDTO;
import com.nhattruongnguyen.dto.response.PostResponseDTO;
import com.nhattruongnguyen.entity.PostEntity;
import com.nhattruongnguyen.exception.StorageException;
import com.nhattruongnguyen.repository.CustomizedPostRepository;
import com.nhattruongnguyen.repository.PostRepository;
import com.nhattruongnguyen.service.PostService;
import com.nhattruongnguyen.service.StorageService;
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
    private PostDetailsResponseConverter postDetailsResponseConverter;
    @Autowired
    private PostEditResponseConverter postEditResponseConverter;
    @Autowired
    private PostSaveRequestConverter postSaveRequestConverter;
    @Autowired
    private CustomizedPostRepository customizedPostRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private StorageService storageService;

    @Override
    public Page<PostResponseDTO> findByConditions(Map<String, Object> params, Pageable pageable) {
       return postSearchResponseConverter.toDTOPage(customizedPostRepository.findByConditions(params, pageable));
    }

    @Override
    public PostDetailsResponseDTO findPostBySlug(String slug) {
        return postDetailsResponseConverter.toDTO(postRepository.findBySlug(slug));
    }

    @Override
    public PostEditResponseDTO findPostEditById(Long postId) {
        if (postId == null) {
            return null;
        }
        return postEditResponseConverter.toDTO(postRepository.findOneById(postId));
    }

    @Override
    public List<PostResponseDTO> findPaginated(Pageable pageable) {
        Page<PostEntity> posts = postRepository.findAll(pageable);
        return postSearchResponseConverter.toDTOGroup(postRepository.findAll(pageable).getContent());
    }

    @Override
    public boolean like(String slug) {
        PostEntity post = postRepository.findBySlug(slug);
        if (post != null)  {
           post.setLikeCount(post.getLikeCount() + 1);
           if ( postRepository.save(post) != null) {
               return true;
           }
        }
        return false;
    }

    @Override
    public Long saveOrUpdate(PostSaveRequestDTO dto) {
        PostEntity entity = postSaveRequestConverter.toEntity(dto);

        if (entity == null) {
            return null;
        }

        String currentThumbnail = entity.getThumbnail();

        try {
            if (!dto.getThumbnailFile().isEmpty()) {
                String newThumbnail = storageService.store(dto.getThumbnailFile(), "post-thumbnail");
                entity.setThumbnail(newThumbnail);
            }
        } catch (StorageException ex) {
            entity.setThumbnail(currentThumbnail);
        }

        PostEntity responseEntity = postRepository.save(entity);

        return responseEntity != null ? responseEntity.getId() : null;
    }
}
