package com.nhattruongnguyen.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {
    @Column
    private String name;

    @ManyToMany
    @JoinTable(name = "categories_posts", joinColumns = @JoinColumn(name = "category_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "post_id", nullable = false))
    private List<PostEntity> posts = new ArrayList<>();
}
