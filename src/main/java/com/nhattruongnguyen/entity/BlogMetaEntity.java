package com.nhattruongnguyen.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "blog_meta")
public class BlogMetaEntity extends BaseEntity {
    @Column(name = "blog_introduce", columnDefinition = "LONGTEXT")
    private String blogIntroduce;

    @Column(name = "blog_name")
    private String blogName;

    @Column(name = "blog_logo_url")
    private String blogLogoUrl;

    public String getBlogIntroduce() {
        return blogIntroduce;
    }

    public void setBlogIntroduce(String blogIntroduce) {
        this.blogIntroduce = blogIntroduce;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getBlogLogoUrl() {
        return blogLogoUrl;
    }

    public void setBlogLogoUrl(String blogLogoUrl) {
        this.blogLogoUrl = blogLogoUrl;
    }
}
