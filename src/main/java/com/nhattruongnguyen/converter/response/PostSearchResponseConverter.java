package com.nhattruongnguyen.converter.response;

import com.nhattruongnguyen.converter.AbstractConverter;
import com.nhattruongnguyen.dto.response.PostSearchResponseDTO;
import com.nhattruongnguyen.entity.PostEntity;
import jakarta.persistence.Converter;
import org.springframework.stereotype.Component;

@Component
public class PostSearchResponseConverter extends AbstractConverter<PostEntity, PostSearchResponseDTO> {
}
