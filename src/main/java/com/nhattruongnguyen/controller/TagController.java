package com.nhattruongnguyen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TagController {
    @GetMapping("admin/tags")
    public String tagsPage() {
        return "admin/tag-list";
    }

    @GetMapping("admin/tag-edit")
    public String tagEditPage() {
        return "admin/tag-edit";
    }
}
