package com.nhattruongnguyen.api;

import com.nhattruongnguyen.dto.response.MessageResponseDTO;
import com.nhattruongnguyen.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class CategoryAPI {
    @Autowired
    private CategoryService categoryService;

    @DeleteMapping({"admin/categories/category-id-{id}", "admin/categories/category-id-{id}/"})
    MessageResponseDTO deleteCategory(@PathVariable Long id) {
        if (categoryService.delete(id)) {
            return ResponseEntity.ok().body(new MessageResponseDTO(200, "success")).getBody();
        }

        return ResponseEntity.badRequest().body(new MessageResponseDTO(400, "bad request")).getBody();
    }
}
