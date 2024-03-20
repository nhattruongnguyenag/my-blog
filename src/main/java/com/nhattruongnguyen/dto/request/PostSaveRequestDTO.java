package com.nhattruongnguyen.dto.request;

import com.nhattruongnguyen.validator.anotation.Slug;
import com.nhattruongnguyen.validator.anotation.Title;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class PostSaveRequestDTO {
    private Long id;
    @Title
    private String title;
    @Size(min = 1, max = 255, message = "{postEdit.descriptionLength}")
    private String description;
    @Size(min = 1, message = "{postEdit.contentNotEmpty}")
    private String content;
    @Slug(messageInRange = "{postEdit.slugLength}", messageUnique = "{postEdit.slugUnique}")
    private String slug;
    private String thumbnail;
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

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
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
