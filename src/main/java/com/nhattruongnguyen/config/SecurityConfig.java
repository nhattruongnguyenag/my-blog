package com.nhattruongnguyen.config;

import com.nhattruongnguyen.security.CustomizedSuccessHandler;
import com.nhattruongnguyen.security.CustomizedUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomizedUserDetailsService();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new CustomizedSuccessHandler();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authenticationProvider(authenticationProvider());

        http.authorizeHttpRequests(authorize ->
                authorize.requestMatchers("/resources/**").permitAll()
                        .requestMatchers("/logout").authenticated()
                        .anyRequest().authenticated());

        http.formLogin(form -> form.loginPage("/mb-login")
                .loginProcessingUrl("/authenticate")
                .successHandler(authenticationSuccessHandler())
                .failureUrl("/mb-login?error=true")
                .usernameParameter("email")
                .passwordParameter("password")
                .permitAll());

        http.logout(logout -> logout.logoutUrl("/logout")
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/mb-login?logout"));

        http.sessionManagement(session -> session.maximumSessions(1).expiredUrl("/mb-login?timeout"));

        return http.build();
    }
}
