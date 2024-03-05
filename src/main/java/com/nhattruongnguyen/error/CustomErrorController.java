package com.nhattruongnguyen.error;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomErrorController {
    @GetMapping("/errors")
    public String errorPage(HttpServletRequest request, HttpServletResponse response, Model model) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        return "web/error";
    }

    @GetMapping({"/about-blog", "/about-blog/"})
    public String aboutBlogPage() {
        return "web/about-blog";
    }
}
