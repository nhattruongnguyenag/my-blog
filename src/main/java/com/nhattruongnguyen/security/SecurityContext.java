package com.nhattruongnguyen.security;

import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityContext {
    public static CustomizedUserDetails getUserLogin() {
        try {
            return (CustomizedUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (RuntimeException ex) {
            return null;
        }
    }
}
