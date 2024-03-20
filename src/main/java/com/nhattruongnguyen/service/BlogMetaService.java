package com.nhattruongnguyen.service;

import com.nhattruongnguyen.dto.request.BlogInfoSaveRequestDTO;
import com.nhattruongnguyen.dto.response.BlogInfoResponseDTO;

public interface BlogMetaService {
    String saveBlogIntroduce(String content);
    String getBlogIntroduce();
    BlogInfoResponseDTO getBlogInfo();
    boolean saveBlogInfo(BlogInfoSaveRequestDTO dto);
}
