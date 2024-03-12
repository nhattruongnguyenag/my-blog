package com.nhattruongnguyen.controller;

import com.nhattruongnguyen.config.SystemConstant;
import com.nhattruongnguyen.dto.response.PostResponseDTO;
import com.nhattruongnguyen.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;

@Controller
public class HomeController {
    @Autowired
    private PostService postService;

    @GetMapping({"/", "/page-{page}", "/page-{page}/"})
    public String homePage(@PathVariable(value = "page", required = false) Integer page, Model model) {
        Page<PostResponseDTO> postPage
                = postService.findByConditions(new HashMap<>(), PageRequest.of(page != null && page > 0 ? page - 1 : 0, SystemConstant.POST_LIMIT_PAGE));
        model.addAttribute("postPage", postPage);
        return "web/home-page";
    }

    @GetMapping({"/about-blog", "/about-blog/"})
    public String aboutBlogPage() {
        return "web/about-blog";
    }
}
