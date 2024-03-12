package com.nhattruongnguyen.converter.request;

import com.nhattruongnguyen.converter.AbstractConverter;
import com.nhattruongnguyen.dto.request.PostSaveRequestDTO;
import com.nhattruongnguyen.entity.CategoryEntity;
import com.nhattruongnguyen.entity.PostEntity;
import com.nhattruongnguyen.repository.CategoryRepository;
import com.nhattruongnguyen.repository.PostRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostSaveRequestConverter extends AbstractConverter<PostEntity, PostSaveRequestDTO> {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public PostEntity toEntity(PostSaveRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        PostEntity postEntity = postRepository.findOneById(dto.getId());

        if (postEntity == null) {
            return null;
        }

        BeanUtils.copyProperties(dto, postEntity);

        for (CategoryEntity category : postEntity.getCategories()) {
            category.getPosts().removeIf(post -> post.getId() == postEntity.getId());
        }

        List<CategoryEntity> categories = categoryRepository.findByIdIn(dto.getCategoryIds());

        for (CategoryEntity category : categories) {
            category.getPosts().add(postEntity);
        }

        postEntity.setCategories(categories);

        return postEntity;
    }
}
