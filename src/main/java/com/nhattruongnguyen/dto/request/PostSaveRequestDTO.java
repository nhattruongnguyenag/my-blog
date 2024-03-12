package com.nhattruongnguyen.dto.request;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class PostSaveRequestDTO {
    private Long id;
    private String title;
    private String description;
    private String content;
    private String slug;
    private MultipartFile thumbnailFile;
    private List<Long> categoryIds;
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public MultipartFile getThumbnailFile() {
        return thumbnailFile;
    }

    public void setThumbnailFile(MultipartFile thumbnailFile) {
        this.thumbnailFile = thumbnailFile;
    }

    public List<Long> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Long> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
