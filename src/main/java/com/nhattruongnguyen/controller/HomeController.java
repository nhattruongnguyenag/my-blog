package com.nhattruongnguyen.controller;

import com.nhattruongnguyen.dto.response.PostResponseDTO;
import com.nhattruongnguyen.properties.PaginationProperties;
import com.nhattruongnguyen.service.BlogMetaService;
import com.nhattruongnguyen.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;

@Controller
public class HomeController {
    @Autowired
    private PostService postService;
    @Autowired
    private BlogMetaService blogMetaService;
    @Autowired
    private PaginationProperties paginationProperties;

    @GetMapping({"/", "/page-{page}", "/page-{page}/"})
    public String homePage(@PathVariable(value = "page", required = false) Integer page, Model model) {
        Sort sort = Sort.by("createdAt").descending();
        Pageable pageable = PageRequest.of(page != null && page > 0 ? page - 1 : 0, paginationProperties.getWebPostNumberItemPerPage(), sort);
        Page<PostResponseDTO> postPage
                = postService.findByConditions(new HashMap<>(), pageable);
        model.addAttribute("postPage", postPage);
        model.addAttribute("pageTitle", "Trang chủ");
        return "web/home-page";
    }

    @GetMapping({"/about-blog", "/about-blog/"})
    public String aboutBlogPage(Model model) {
        model.addAttribute("content", blogMetaService.getBlogIntroduce());
        model.addAttribute("pageTitle", "Về Blog");
        return "web/about-blog";
    }
}
