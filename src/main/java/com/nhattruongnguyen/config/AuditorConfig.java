package com.nhattruongnguyen.config;

import com.nhattruongnguyen.config.security.CustomizedUserDetails;
import com.nhattruongnguyen.config.security.SecurityContextUtils;
import com.nhattruongnguyen.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
class AuditorConfig {
    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }

    static class AuditorAwareImpl implements AuditorAware<String> {
        @Autowired
        private SecurityContextUtils securityContextUtils;

        @Override
        public Optional<String> getCurrentAuditor() {
            CustomizedUserDetails user = securityContextUtils.getUserLogin();
            return Optional.of(user != null ? user.getName() : "anonymousUser");
        }
    }
}
