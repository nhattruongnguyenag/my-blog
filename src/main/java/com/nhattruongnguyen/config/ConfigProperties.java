package com.nhattruongnguyen.config;

import com.nhattruongnguyen.properties.StorageProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigProperties {
    @Bean
    @ConfigurationProperties(prefix = "blog.storage")
    StorageProperty storageProperty() {
        return new StorageProperty();
    }
}
