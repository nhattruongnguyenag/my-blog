package com.nhattruongnguyen.config.security;

import com.nhattruongnguyen.dto.UserDTO;
import com.nhattruongnguyen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class CustomizedUserDetailsService implements UserDetailsService {
    public static final int ACTIVE = 1;
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO userDTO = userService.findOneByEmailAndActive(username, ACTIVE);
        if (userDTO == null) {
            throw new UsernameNotFoundException("user not found");
        }

        List<GrantedAuthority> authorities = userDTO.getRoles()
                .stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getCode())).collect(Collectors.toList());

        CustomizedUserDetails customizedUserDetails = new CustomizedUserDetails(username, userDTO.getPassword(), true, true, true, true, authorities);
        customizedUserDetails.setId(userDTO.getId());
        customizedUserDetails.setEmail(userDTO.getEmail());
        customizedUserDetails.setName(userDTO.getName());
        customizedUserDetails.setAvatar(userDTO.getAvatar());
        return customizedUserDetails;

    }
}
