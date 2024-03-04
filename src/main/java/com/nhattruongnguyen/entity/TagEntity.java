package com.nhattruongnguyen.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tags")
public class TagEntity extends BaseEntity {
    @Column
    private String name;
    @ManyToMany
    @JoinTable(name = "tags_posts", joinColumns = @JoinColumn(name = "tag_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "post_id", nullable = false))
    private List<PostEntity> posts = new ArrayList<>();
}
