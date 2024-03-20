package com.nhattruongnguyen.service.impl;

import com.nhattruongnguyen.converter.response.BlogInfoResponseConverter;
import com.nhattruongnguyen.dto.request.BlogInfoSaveRequestDTO;
import com.nhattruongnguyen.dto.response.BlogInfoResponseDTO;
import com.nhattruongnguyen.entity.BlogMetaEntity;
import com.nhattruongnguyen.exception.StorageException;
import com.nhattruongnguyen.repository.BlogMetaRepository;
import com.nhattruongnguyen.service.BlogMetaService;
import com.nhattruongnguyen.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class BlogMetaServiceImpl implements BlogMetaService {
    @Autowired
    private StorageService storageService;
    @Autowired
    private BlogMetaRepository blogMetaRepository;
    @Autowired
    private BlogInfoResponseConverter blogInfoResponseConverter;

    @Override
    public String saveBlogIntroduce(String content) {
        Page<BlogMetaEntity> metaEntityPage = blogMetaRepository.findAll(PageRequest.of(0, 1));

        BlogMetaEntity blogMetaEntity = null;
        if (metaEntityPage.getTotalElements() > 0) {
            blogMetaEntity = metaEntityPage.getContent().get(0);
            blogMetaEntity.setBlogIntroduce(content);
        } else {
            blogMetaEntity = new BlogMetaEntity();
            blogMetaEntity.setBlogIntroduce(content);
        }

        BlogMetaEntity result = blogMetaRepository.save(blogMetaEntity);

        return result != null ? result.getBlogIntroduce() : null;
    }

    @Override
    public String getBlogIntroduce() {
        Page<BlogMetaEntity> metaEntityPage = blogMetaRepository.findAll(PageRequest.of(0, 1));
        if (metaEntityPage.getTotalElements() > 0) {
            BlogMetaEntity blogMetaEntity = metaEntityPage.getContent().get(0);
            return blogMetaEntity.getBlogIntroduce();
        }
        return null;
    }

    @Override
    public BlogInfoResponseDTO getBlogInfo() {
        Page<BlogMetaEntity> metaEntityPage = blogMetaRepository.findAll(PageRequest.of(0, 1));
        if (metaEntityPage.getTotalElements() > 0) {
            BlogMetaEntity blogMetaEntity = metaEntityPage.getContent().get(0);
            return blogInfoResponseConverter.toDTO(blogMetaEntity);
        }
        return new BlogInfoResponseDTO();
    }

    @Override
    public boolean saveBlogInfo(BlogInfoSaveRequestDTO dto) {
        Page<BlogMetaEntity> metaEntityPage = blogMetaRepository.findAll(PageRequest.of(0, 1));
        if (metaEntityPage.getTotalElements() > 0) {
            BlogMetaEntity blogMetaEntity = metaEntityPage.getContent().get(0);

            if (dto.getName() != null && !dto.getName().isBlank()) {
                blogMetaEntity.setBlogName(dto.getName());
            }

            String currentLogo = blogMetaEntity.getBlogLogoUrl();

            try {
                if (!dto.getLogoFile().isEmpty()) {
                    String newLogo = storageService.store(dto.getLogoFile(), "blog");
                    blogMetaEntity.setBlogLogoUrl(newLogo);
                }
            } catch (StorageException ex) {
                blogMetaEntity.setBlogLogoUrl(currentLogo);
            }

            return blogMetaRepository.save(blogMetaEntity) != null;
        }

        return false;
    }
}
