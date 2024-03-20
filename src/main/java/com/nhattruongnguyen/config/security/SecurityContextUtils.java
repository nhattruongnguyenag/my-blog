package com.nhattruongnguyen.config.security;

import com.nhattruongnguyen.dto.UserDTO;
import com.nhattruongnguyen.service.UserService;
import com.nhattruongnguyen.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class SecurityContextUtils {
    public CustomizedUserDetails getUserLogin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            if (userDetails instanceof CustomizedUserDetails) {
                return (CustomizedUserDetails) userDetails;
            }
        }

        return null;
    }
}
