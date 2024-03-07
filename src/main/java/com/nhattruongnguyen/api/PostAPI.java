package com.nhattruongnguyen.api;

import com.nhattruongnguyen.dto.response.MessageResponseDTO;
import com.nhattruongnguyen.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
}
