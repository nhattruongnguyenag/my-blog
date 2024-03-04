package com.nhattruongnguyen.controller;

import com.nhattruongnguyen.dto.request.CategorySaveRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {
    @GetMapping("admin/categories")
    public String categoriesPage() {
        return "admin/category-list";
    }

    @GetMapping("admin/category-edit")
    public String categoryEditPage(Model model) {
        model.addAttribute("category", new CategorySaveRequest());
        return "admin/category-edit";
    }

    @PostMapping("admin/categories")
    public String categorySave(CategorySaveRequest category) {
        return "redirect:/admin/categories";
    }
}
