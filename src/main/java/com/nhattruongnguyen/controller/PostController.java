package com.nhattruongnguyen.controller;

import com.nhattruongnguyen.config.SystemConstant;
import com.nhattruongnguyen.dto.response.CategoryResponseDTO;
import com.nhattruongnguyen.dto.response.PostSearchResponseDTO;
import com.nhattruongnguyen.entity.PostEntity;
import com.nhattruongnguyen.repository.CustomizedPostRepository;
import com.nhattruongnguyen.service.CategoryService;
import com.nhattruongnguyen.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping({"{slug}","{slug}/", "c/{slug}/page-{page}", "c/{slug}/page-{page}/"})
    private String findPostsByCategory(@PathVariable String slug, @PathVariable(required = false) Integer page, Model model) {
        Map<String, Object> params = new HashMap<>();
        params.put("category", slug);

        CategoryResponseDTO categoryResponse = categoryService.findOneBySlug(slug);

        if (categoryResponse != null) {
            Page<PostSearchResponseDTO> postPage
                    = postService.findByConditions(params, PageRequest.of(page != null ? page : 1, SystemConstant.POST_LIMIT_PAGE));
            categoryResponse.setPosts(postPage);

            model.addAttribute("category", categoryResponse);
            return "web/category-post";
        }

        PostSearchResponseDTO post = postService.findPostBySlug(slug);
        model.addAttribute("post", post);
        return "web/post-details";
    }


    @GetMapping("admin/posts")
    public String postsPage(Map<String, Object> params, Model model) {
        params.put("limit", SystemConstant.POST_LIMIT_PAGE);
//        List<PostSearchResponseDTO> posts = postService.findByConditions(params, PageRequest.of(params.get()));
//        model.addAttribute("posts", posts);
        return "admin/post-list";
    }

    @GetMapping("admin/post-edit")
    public String postEditPage() {
        return "admin/post-edit";
    }
}
