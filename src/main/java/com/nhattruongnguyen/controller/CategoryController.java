package com.nhattruongnguyen.controller;

import com.nhattruongnguyen.config.SystemConstant;
import com.nhattruongnguyen.dto.request.CategorySaveRequest;
import com.nhattruongnguyen.entity.CategoryEntity;
import com.nhattruongnguyen.repository.CategoryRepository;
import com.nhattruongnguyen.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping({"admin/categories", "admin/categories/", "admin/categories/page-{page}", "admin/categories/page-{page}/"})
    public String categoriesPage(@PathVariable(required = false) Integer page, Model model) {
        model.addAttribute("categoryPage", categoryService.findAll(PageRequest.of(page != null && page > 0 ? page - 1 : 0, SystemConstant.CATEGORY_LIMIT_ADMIN_PAGE)));
        model.addAttribute("pageTitle", "Danh mục");
        return "admin/category-list";
    }

    @GetMapping({"admin/category-edit", "admin/category-edit/", "admin/category-edit/category-id-{id}", "admin/category-edit/category-id-{id}/"})
    public String categoryEditPage(@PathVariable(required = false) Long id, Model model) {
        model.addAttribute("category", new CategorySaveRequest());
        model.addAttribute("pageTitle", "Thêm danh mục");
        return "admin/category-edit";
    }

    @PostMapping("admin/categories")
    public String categorySave(CategorySaveRequest category) {
        return "redirect:/admin/categories";
    }
}
