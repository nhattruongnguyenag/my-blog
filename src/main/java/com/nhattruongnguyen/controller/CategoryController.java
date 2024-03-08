package com.nhattruongnguyen.controller;

import com.nhattruongnguyen.dto.request.CategorySaveRequest;
import com.nhattruongnguyen.entity.CategoryEntity;
import com.nhattruongnguyen.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("admin/categories")
    public String categoriesPage() {
        return "admin/category-list";
    }

    @GetMapping("admin/category-edit")
    public String categoryEditPage(Model model) {
        model.addAttribute("category", new CategorySaveRequest());
        return "admin/category-edit";
    }

    @GetMapping("admin/test")
    @ResponseBody
    public void test() {
//        CategoryEntity categoryEntity = new CategoryEntity();
//        categoryEntity.setId(6l);
//        categoryEntity.setSlug("category-6");
//        categoryEntity.setName("Category 6");
//        categoryRepository.save(categoryEntity);
        Optional<String> test = Optional.of(null);

    }

    @PostMapping("admin/categories")
    public String categorySave(CategorySaveRequest category) {
        return "redirect:/admin/categories";
    }
}
