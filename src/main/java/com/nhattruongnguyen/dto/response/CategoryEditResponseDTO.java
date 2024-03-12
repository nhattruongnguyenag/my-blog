package com.nhattruongnguyen.dto.response;

import com.nhattruongnguyen.dto.BaseDTO;

public class CategoryEditResponseDTO extends BaseDTO {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
