package com.nhattruongnguyen.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "posts_trashs")
public class PostTrashEntity extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "post_id", nullable = false)
    PostEntity post;

    public PostEntity getPost() {
        return post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }
}
