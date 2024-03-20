package com.nhattruongnguyen.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
public class PostEntity extends BaseEntity {
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String thumbnail;
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    @Column(unique = true)
    private String slug;
    @Column(name = "view_count")
    private Long viewCount = 0l;
    @Column(name = "like_count")
    private Long likeCount = 0l;
    @Column
    private Integer status = 0;
    @ManyToMany(mappedBy = "posts")
    private List<CategoryEntity> categories = new ArrayList<>();
    @ManyToMany(mappedBy = "posts")
    private List<TagEntity> tags = new ArrayList<>();
    @OneToOne(mappedBy = "post",cascade = CascadeType.ALL, orphanRemoval = true)
    private PostTrashEntity postTrash;

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

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
    }

    public List<TagEntity> getTags() {
        return tags;
    }

    public void setTags(List<TagEntity> tags) {
        this.tags = tags;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public PostTrashEntity getPostTrash() {
        return postTrash;
    }

    public void setPostTrash(PostTrashEntity postTrash) {
        this.postTrash = postTrash;
    }
}
