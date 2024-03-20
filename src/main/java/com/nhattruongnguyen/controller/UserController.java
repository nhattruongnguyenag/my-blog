package com.nhattruongnguyen.controller;

import com.nhattruongnguyen.config.security.SecurityContextUtils;
import com.nhattruongnguyen.converter.request.ChangePasswordRequestDTO;
import com.nhattruongnguyen.dto.UserDTO;
import com.nhattruongnguyen.dto.request.UserProfileSaveRequestDTO;
import com.nhattruongnguyen.dto.response.UserProfileResponseDTO;
import com.nhattruongnguyen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SecurityContextUtils securityContextUtils;

    @GetMapping({"admin/user-profile", "admin/user-profile/"})
    public String userProfilePage(Model model) {
        String email =  securityContextUtils.getUserLogin().getEmail();
        UserDTO userDTO = userService.findOneByEmailAndActive(email, 1);
        model.addAttribute("user", userDTO);
        model.addAttribute("pageTitle", "Hồ sơ");
        return "admin/user-profile";
    }

    @PostMapping({"admin/user-profile", "admin/user-profile/"})
    public String saveUserProfile(final UserProfileSaveRequestDTO dto) {
        userService.saveUserProfile(dto);
        return "redirect:/admin/user-profile";
    }

    @GetMapping({"admin/change-password", "admin/change-password/"})
    public String changePasswordPage(Model model) {
        model.addAttribute("pageTitle", "Đổi mật khẩu");
        return "admin/change-password";
    }

    @PostMapping({"admin/change-password", "admin/change-password/"})
    public String changePassword(ChangePasswordRequestDTO dto) {
        boolean isSuccess = userService.changePassword(dto);
        if (isSuccess) {
            return "admin/change-password";
        }
        return "redirect:/admin/change-password?change_password_fail=true";
    }

    @GetMapping({"mb-login", "mb-login/"})
    public String loginEditPage() {
        return "admin/login";
    }
}
