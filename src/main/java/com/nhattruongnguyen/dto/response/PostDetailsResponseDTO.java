package com.nhattruongnguyen.dto.response;

import com.nhattruongnguyen.dto.BaseDTO;

import java.util.Date;
import java.util.List;

public class PostDetailsResponseDTO extends BaseDTO {
    private String title;
    private String description;
    private String thumbnail;
    private String content;
    private String slug;
    private Long viewCount;
    private Long likeCount;
    private List<PostResponseDTO> relatedPosts;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public List<PostResponseDTO> getRelatedPosts() {
        return relatedPosts;
    }

    public void setRelatedPosts(List<PostResponseDTO> relatedPosts) {
        this.relatedPosts = relatedPosts;
    }
}
