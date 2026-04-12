package com.blog.blogrbac_system.controller;


import com.blog.blogrbac_system.constant.RESPONSE;
import com.blog.blogrbac_system.dto.response.FileStorageResponse;
import com.blog.blogrbac_system.service.FileStorageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("picture")
@AllArgsConstructor
public class UploadedPicture {

    private final FileStorageService fileStorageService;

    @PostMapping("/upload")
    public ResponseEntity<FileStorageResponse> uploadFile(
            @RequestParam("file") MultipartFile file
    ){
        return ResponseEntity.ok(fileStorageService.uploadFile(file));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteFile(
            @RequestParam("picture_id") String id
    ){
        fileStorageService.deleteFile(id);
        return RESPONSE.DELETED_SUCCESS_MSG();
    }

}
