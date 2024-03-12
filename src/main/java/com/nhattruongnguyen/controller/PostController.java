package com.nhattruongnguyen.controller;

import com.nhattruongnguyen.config.SystemConstant;
import com.nhattruongnguyen.dto.request.PostSaveRequestDTO;
import com.nhattruongnguyen.dto.response.CategoryResponseDTO;
import com.nhattruongnguyen.dto.response.PostDetailsResponseDTO;
import com.nhattruongnguyen.dto.response.PostEditResponseDTO;
import com.nhattruongnguyen.dto.response.PostResponseDTO;
import com.nhattruongnguyen.exception.PageNotFoundException;
import com.nhattruongnguyen.properties.StorageProperty;
import com.nhattruongnguyen.service.CategoryService;
import com.nhattruongnguyen.service.PostService;
import com.nhattruongnguyen.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class PostController {
    public static final int PUBLISH = 1;
    public static final int DRAFT = 2;
    @Autowired
    private PostService postService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private StorageProperty uploadProperties;
    @Autowired
    private StorageService storageService;

    @GetMapping({"{slug}","{slug}/", "{slug}/page-{page}", "{slug}/page-{page}/"})
    private String findPostsByCategory(@PathVariable String slug, @PathVariable(required = false) Integer page, Model model) {
        Map<String, Object> params = new HashMap<>();
        params.put("category", slug);

        CategoryResponseDTO categoryResponse = categoryService.findOneBySlug(slug);

        if (categoryResponse != null) {
            Page<PostResponseDTO> postPage
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
        Page<PostResponseDTO> postPage
                = postService.findByConditions(new HashMap<>(), PageRequest.of(page != null && page > 0 ? page - 1 : 0, SystemConstant.POST_LIMIT_ADMIN_PAGE));
        model.addAttribute("postPage", postPage);
        model.addAttribute("pageTitle", "Bài viết");
        return "admin/post-list";
    }

    @GetMapping({"admin/post-edit","admin/post-edit/", "admin/post-edit/post-id-{id}", "admin/post-edit/post-id-{id}/"})
    public String postEditPage(@PathVariable(required = false) Long id, Model model) {
        PostEditResponseDTO post = postService.findPostEditById(id);

        if (post == null) {
            post = new PostEditResponseDTO();
        }

        model.addAttribute("post", post);
        model.addAttribute("pageTitle", id == null ? "Thêm bài viết" : "Cập nhật bài viết");

        return "admin/post-edit";
    }

    @PostMapping(value = {"admin/posts", "admin/posts/"})
    public String savePost(final PostSaveRequestDTO dto, final String action) {
        if (action.equalsIgnoreCase("publish")) {
            dto.setStatus(PUBLISH);
        } else if (action.equalsIgnoreCase("daft")) {
            dto.setStatus(DRAFT);
        }
        postService.saveOrUpdate(dto);
        return "redirect:/admin/posts";
    }

}
