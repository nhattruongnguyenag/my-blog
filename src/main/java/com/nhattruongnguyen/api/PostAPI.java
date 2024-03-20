package com.nhattruongnguyen.api;

import com.nhattruongnguyen.dto.request.PostSaveRequestDTO;
import com.nhattruongnguyen.dto.response.MessageResponseDTO;
import com.nhattruongnguyen.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class PostAPI {
    @Autowired
    private PostService postService;

    @PostMapping({"post-like/{slug}", "post-like/{slug}/"})
    MessageResponseDTO likePost(@PathVariable String slug) {
        if (postService.like(slug)) {
            return ResponseEntity.ok().body(new MessageResponseDTO(200, "success")).getBody();
        }

        return ResponseEntity.badRequest().body(new MessageResponseDTO(400, "bad request")).getBody();
    }

    @PutMapping({"admin/posts/{action}/post-id-{id}", "admin/posts/{action}/post-id-{id}/"})
    MessageResponseDTO changePostState(@PathVariable Long id, @PathVariable String action) {
        if (postService.changePostState(id, action)) {
            return ResponseEntity.ok().body(new MessageResponseDTO(200, "success")).getBody();
        }

        return ResponseEntity.badRequest().body(new MessageResponseDTO(400, "bad request")).getBody();
    }
}
