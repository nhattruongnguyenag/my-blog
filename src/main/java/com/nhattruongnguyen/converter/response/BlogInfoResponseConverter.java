package com.nhattruongnguyen.converter.response;

import com.nhattruongnguyen.converter.AbstractConverter;
import com.nhattruongnguyen.dto.response.BlogInfoResponseDTO;
import com.nhattruongnguyen.entity.BlogMetaEntity;
import org.springframework.stereotype.Component;

@Component
public class BlogInfoResponseConverter extends AbstractConverter<BlogMetaEntity, BlogInfoResponseDTO> {
    @Override
    public BlogInfoResponseDTO toDTO(BlogMetaEntity entity) {
        if (entity == null) {
            return null;
        }

        BlogInfoResponseDTO dto = super.toDTO(entity);
        dto.setName(entity.getBlogName());
        dto.setLogo(entity.getBlogLogoUrl());
        return dto;
    }
}
