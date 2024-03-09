package com.nhattruongnguyen.controller;

import com.nhattruongnguyen.config.SystemConstant;
import com.nhattruongnguyen.dto.response.CategoryResponseDTO;
import com.nhattruongnguyen.dto.response.PostDetailsResponseDTO;
import com.nhattruongnguyen.dto.response.PostSearchResponseDTO;
import com.nhattruongnguyen.entity.PostEntity;
import com.nhattruongnguyen.exception.PageNotFoundException;
import com.nhattruongnguyen.repository.CustomizedPostRepository;
import com.nhattruongnguyen.service.CategoryService;
import com.nhattruongnguyen.service.PostService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping({"{slug}","{slug}/", "{slug}/page-{page}", "{slug}/page-{page}/"})
    private String findPostsByCategory(@PathVariable String slug, @PathVariable(required = false) Integer page, Model model) {
        Map<String, Object> params = new HashMap<>();
        params.put("category", slug);

        CategoryResponseDTO categoryResponse = categoryService.findOneBySlug(slug);

        if (categoryResponse != null) {
            Page<PostSearchResponseDTO> postPage
                    = postService.findByConditions(params, PageRequest.of(page != null && page > 0 ? page - 1 : 0, SystemConstant.POST_LIMIT_PAGE));
            categoryResponse.setPosts(postPage);

            model.addAttribute("category", categoryResponse);
            return "web/category-post";
        }

        PostDetailsResponseDTO post = postService.findPostBySlug(slug);

        if (post == null) {
            throw new PageNotFoundException();
        }

        model.addAttribute("post", post);
        return "web/post-details";
    }


    @GetMapping({"admin/posts", "admin/posts/", "admin/posts/page-{page}", "admin/posts/page-{page}/"})
    public String postsPage(@PathVariable(value = "page", required = false) Integer page, Model model) {
        StringBuffer stringBuffer = new StringBuffer();
        Page<PostSearchResponseDTO> postPage
                = postService.findByConditions(new HashMap<>(), PageRequest.of(page != null && page > 0 ? page - 1 : 0, SystemConstant.POST_LIMIT_ADMIN_PAGE));
        model.addAttribute("postPage", postPage);
        model.addAttribute("pageTitle", "Bài viết");
        return "admin/post-list";
    }

    @GetMapping({"admin/post-edit","admin/post-edit/", "admin/post-edit/post-id-{id}", "admin/post-edit/post-id-{id}/"})
    public String postEditPage(@PathVariable(required = false) Long id, Model model) {
        model.addAttribute("pageTitle", "Thêm bài viết");
        return "admin/post-edit";
    }
}
