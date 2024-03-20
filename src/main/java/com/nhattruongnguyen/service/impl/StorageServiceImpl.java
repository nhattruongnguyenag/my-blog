package com.nhattruongnguyen.service.impl;

import com.nhattruongnguyen.exception.StorageException;
import com.nhattruongnguyen.exception.StorageFileNotFoundException;
import com.nhattruongnguyen.properties.StorageProperties;
import com.nhattruongnguyen.service.StorageService;
import com.nhattruongnguyen.utils.HashingUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageProperties storageProperty;

    private Path rootLocation;

    @Autowired
    public StorageServiceImpl(StorageProperties properties) {

        if(properties.getLocation().trim().length() == 0){
            throw new StorageException("File upload location can not be Empty.");
        }

        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public String store(MultipartFile file, String subFolder) {
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file.");
            }

            createSubFolderIfNotExists(subFolder);

            Path destinationFile = this.rootLocation.resolve(subFolder + File.separator + createFileName(file)).normalize().toAbsolutePath();

            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }

            return destinationFile.getFileName().toString();
        } catch (IOException e) {
            throw new StorageException("Failed to store file.", e);
        }
    }

    private Path createFileName(MultipartFile file) {
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        String baseName = HashingUtils.createMD5(String.valueOf(System.nanoTime()), HashingUtils.MD5);
        return Paths.get( String.join(".", baseName, extension));
    }

    private void createSubFolderIfNotExists(String subFolder) {
        File file = new File(String.join("/", storageProperty.getLocation(), subFolder));
        if (!file.exists()) {
            file.mkdir();
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(this.rootLocation::relativize);
        } catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        }
    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename, String subFolder) {
        try {
            Path file = load(String.join("/", subFolder, filename));
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new StorageFileNotFoundException(
                        "Could not read file: " + filename);

            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    @Override
    public boolean deleteAll() {
        return FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }
}
