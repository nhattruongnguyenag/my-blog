package com.nhattruongnguyen.controller;

import com.nhattruongnguyen.dto.request.BlogInfoSaveRequestDTO;
import com.nhattruongnguyen.service.BlogMetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogMetaControllder {
    @Autowired
    private BlogMetaService blogMetaService;

    @GetMapping({"admin/blog/introduce", "admin/blog/introduce/"})
    public String blogIntroducePage(Model model) {
        model.addAttribute("content", blogMetaService.getBlogIntroduce());
        model.addAttribute("pageTitle", "Giới thiệu");
        return "admin/blog-introduce";
    }

    @PostMapping({"admin/blog/introduce", "admin/blog/introduce/"})
    public String saveBlogIntroduce(String content) {
        blogMetaService.saveBlogIntroduce(content);
        return "redirect:/admin/blog/introduce";
    }

    @GetMapping({"admin/blog/info", "admin/blog/info/"})
    public String blogInfoPage(Model model) {
        model.addAttribute("pageTitle", "Thông tin");
        return "admin/blog-info";
    }

    @PostMapping({"admin/blog/info", "admin/blog/info/"})
    public String saveBlogInfo(BlogInfoSaveRequestDTO dto) {
        blogMetaService.saveBlogInfo(dto);
        return "redirect:/admin/blog/info";
    }
}
