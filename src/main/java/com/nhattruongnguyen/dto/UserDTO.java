package com.nhattruongnguyen.dto;

import com.nhattruongnguyen.entity.LogEntity;
import com.nhattruongnguyen.entity.RoleEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private String email;
    private String name;
    private String avatar;
    private String password;
    private Integer active;
    private List<RoleDTO> roles = new ArrayList<>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }
}
