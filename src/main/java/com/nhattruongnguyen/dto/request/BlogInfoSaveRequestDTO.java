package com.nhattruongnguyen.dto.request;

import org.springframework.web.multipart.MultipartFile;

public class BlogInfoSaveRequestDTO {
    private MultipartFile logoFile;
    private String name;

    public MultipartFile getLogoFile() {
        return logoFile;
    }

    public void setLogoFile(MultipartFile logoFile) {
        this.logoFile = logoFile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
