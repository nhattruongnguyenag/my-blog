package com.nhattruongnguyen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("admin/user-profile")
    public String userProfilePage() {
        return "admin/user-profile";
    }

    @GetMapping("admin/change-password")
    public String changePasswordPage() {
        return "admin/change-password";
    }

    @GetMapping("admin/mb-login")
    public String loginEditPage() {
        return "admin/login";
    }
}
