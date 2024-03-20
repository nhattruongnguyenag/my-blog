package com.nhattruongnguyen.config;

import com.nhattruongnguyen.properties.BlogProperties;
import com.nhattruongnguyen.properties.PaginationProperties;
import com.nhattruongnguyen.properties.StorageProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesConfig {
    @Bean
    @ConfigurationProperties(prefix = "blog.storage")
    StorageProperties storageProperties() {
        return new StorageProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "blog.pagination")
    PaginationProperties paginationProperties() {
        return new PaginationProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "blog.meta")
    BlogProperties blogProperties() {
        return new BlogProperties();
    }
}
