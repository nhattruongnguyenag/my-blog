package com.nhattruongnguyen.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "application")
public class SystemConstant {
    public static final int POST_LIMIT_PAGE = 12;
    public static final int POST_LIMIT_ADMIN_PAGE = 5;
    public static final int CATEGORY_LIMIT_ADMIN_PAGE = 5;
    public static final String ADMIN_HOME = "/admin/posts/publish";

}
