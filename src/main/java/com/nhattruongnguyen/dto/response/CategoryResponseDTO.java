package com.nhattruongnguyen.dto.response;

import com.nhattruongnguyen.dto.BaseDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public class CategoryResponseDTO extends BaseDTO {
    private String name;
    private String slug;
    private Integer postCount = 0;
    private Page<PostSearchResponseDTO> posts;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Page<PostSearchResponseDTO> getPosts() {
        return posts;
    }

    public void setPosts(Page<PostSearchResponseDTO> posts) {
        this.posts = posts;
    }

    public Integer getPostCount() {
        return postCount;
    }

    public void setPostCount(Integer postCount) {
        this.postCount = postCount;
    }
}
