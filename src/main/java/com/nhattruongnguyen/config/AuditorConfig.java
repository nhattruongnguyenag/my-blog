package com.nhattruongnguyen.config;

import com.nhattruongnguyen.security.CustomizedUserDetails;
import com.nhattruongnguyen.security.SecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
class AuditorConfig {
    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }

    static class AuditorAwareImpl implements AuditorAware<String> {
        @Override
        public Optional<String> getCurrentAuditor() {
            CustomizedUserDetails user = SecurityContext.getUserLogin();
            return Optional.of(user != null ? user.getName() : "anonymousUser");
        }
    }
}
