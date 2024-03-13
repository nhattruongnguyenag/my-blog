package com.nhattruongnguyen.service.impl;

import com.nhattruongnguyen.converter.request.PostSaveRequestConverter;
import com.nhattruongnguyen.converter.response.PostDetailsResponseConverter;
import com.nhattruongnguyen.converter.response.PostEditResponseConverter;
import com.nhattruongnguyen.converter.response.PostSearchResponseConverter;
import com.nhattruongnguyen.dto.request.PostSaveRequestDTO;
import com.nhattruongnguyen.dto.response.PostDetailsResponseDTO;
import com.nhattruongnguyen.dto.response.PostEditResponseDTO;
import com.nhattruongnguyen.dto.response.PostResponseDTO;
import com.nhattruongnguyen.entity.CategoryEntity;
import com.nhattruongnguyen.entity.PostEntity;
import com.nhattruongnguyen.entity.PostTrashEntity;
import com.nhattruongnguyen.enums.PostAction;
import com.nhattruongnguyen.exception.StorageException;
import com.nhattruongnguyen.repository.CategoryRepository;
import com.nhattruongnguyen.repository.CustomizedPostRepository;
import com.nhattruongnguyen.repository.PostRepository;
import com.nhattruongnguyen.service.PostService;
import com.nhattruongnguyen.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<PostResponseDTO> findByConditions(Map<String, Object> params, Pageable pageable) {
        return postSearchResponseConverter.toDTOPage(customizedPostRepository.findByConditions(params, pageable));
    }

    @Override
    public Page<PostResponseDTO> findPostsInTrash(Pageable pageable) {
        return postSearchResponseConverter.toDTOPage(postRepository.findPostsInTrashWithPagination(pageable));
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
        if (post != null) {
            post.setLikeCount(post.getLikeCount() + 1);
            if (postRepository.save(post) != null) {
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

    @Override
    @Transactional
    public boolean changePostState(Long postId, String action) {
        PostEntity entity = postRepository.findOneById(postId);

        if (entity == null) {
            return false;
        }

        if (action.equalsIgnoreCase(PostAction.DELETE.getName())) {
            try{
                for (CategoryEntity category : entity.getCategories()) {
                    category.getPosts().removeIf(post -> post.getId().equals(entity.getId()));
                }
                categoryRepository.saveAll(entity.getCategories());
                postRepository.deleteById(postId);
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        if (action.equalsIgnoreCase(PostAction.ACHIEVE.getName())) {
            entity.setStatus(PostAction.ACHIEVE.getValue());
        } else if (action.equalsIgnoreCase(PostAction.TRASH.getName())) {
            PostTrashEntity postTrashEntity = new PostTrashEntity();
            postTrashEntity.setPost(entity);
            entity.setPostTrash(postTrashEntity);
            postRepository.save(entity);
        } else if (action.equals(PostAction.RESTORE.getName())) {
            entity.setPostTrash(null);
        }

        entity.setUpdatedAt(new Date());
        return postRepository.save(entity) != null;
    }
}
