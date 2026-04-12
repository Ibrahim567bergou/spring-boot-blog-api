package com.blog.blogrbac_system.service;

import com.blog.blogrbac_system.dto.response.FileStorageResponse;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    FileStorageResponse uploadFile(MultipartFile file);
    void deleteFile(String pictureId);


}
