package com.nhattruongnguyen.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {
    String store(MultipartFile file, String subFolder);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename, String subFolder);

    boolean deleteAll();
}
