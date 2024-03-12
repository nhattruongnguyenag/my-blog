package com.nhattruongnguyen.controller;

import com.nhattruongnguyen.service.StorageService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class MediaController {
    @Autowired
    private StorageService storageService;

    @PostMapping("/upload/image")
    public String uploadImageHandle(@RequestPart MultipartFile upload, HttpServletRequest request) {
        System.out.println(upload);
        return null;
    }

    @GetMapping({ "files/{subFolder}/{fileName}", "files/{subFolder}/{fileName}/" })
    public ResponseEntity<Resource> getImage(@PathVariable String fileName, @PathVariable String subFolder) throws IOException {
        Resource image = storageService.loadAsResource(fileName, subFolder);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "image/jpeg");
        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(image);
    }
}
