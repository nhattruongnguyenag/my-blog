package com.nhattruongnguyen.converter.response;

import com.nhattruongnguyen.converter.AbstractConverter;
import com.nhattruongnguyen.dto.response.PostDetailsResponseDTO;
import com.nhattruongnguyen.entity.PostEntity;
import com.nhattruongnguyen.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostDetailsResponseConverter extends AbstractConverter<PostEntity, PostDetailsResponseDTO> {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostSearchResponseConverter postSearchResponseConverter;

    @Override
    public PostDetailsResponseDTO toDTO(PostEntity entity) {
        PostDetailsResponseDTO post = super.toDTO(entity);
        if (post != null) {
            List<PostEntity> postEntities = postRepository.findRelatedPost(entity.getSlug());
            post.setRelatedPosts(postSearchResponseConverter.toDTOGroup(postEntities));
        }
        return post;
    }
}
