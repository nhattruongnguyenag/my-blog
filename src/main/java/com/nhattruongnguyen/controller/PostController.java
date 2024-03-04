package com.nhattruongnguyen.controller;

import com.nhattruongnguyen.config.SystemConstant;
import com.nhattruongnguyen.dto.response.PostSearchResponseDTO;
import com.nhattruongnguyen.entity.PostEntity;
import com.nhattruongnguyen.repository.CustomizedPostRepository;
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

    @GetMapping({"/{slug}", "/{slug}/"})
    public String home(@PathVariable("slug") String slug, Model model) {
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

    @GetMapping("/test")
    @ResponseBody
    private Page<PostSearchResponseDTO> test(@RequestParam("page") Integer page) {
        return postService.findByConditions(new HashMap<>(), PageRequest.of(page, 1));
    }
}
