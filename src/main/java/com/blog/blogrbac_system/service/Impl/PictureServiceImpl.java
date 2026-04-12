package com.blog.blogrbac_system.service.Impl;

import com.blog.blogrbac_system.dto.response.FileStorageResponse;
import com.blog.blogrbac_system.dto.response.PictureResponse;
import com.blog.blogrbac_system.entity.Picture;
import com.blog.blogrbac_system.exception.exceptions.PictureNotFoundException;
import com.blog.blogrbac_system.mapper.PictureMapper;
import com.blog.blogrbac_system.repository.PictureRepository;
import com.blog.blogrbac_system.service.FileStorageService;
import com.blog.blogrbac_system.service.PictureService;
import com.blog.blogrbac_system.utils.FileUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;


@Service
@AllArgsConstructor
public class PictureServiceImpl implements PictureService {

    private final PictureRepository pictureRepository;
    private final FileStorageService fileStorageService;


    @Override
    public Picture uploadPicture(MultipartFile file) {
        String originName = file.getOriginalFilename();
        String extension = null;
        if(originName != null){
             extension = FileUtil.getFileExtension(originName);
        }
        FileStorageResponse fileStorageResponse = fileStorageService.uploadFile(file);
        Picture picture = new Picture();
        picture.setExtension(extension);
        picture.setUploadAt(Instant.now());
        picture.setUrl(fileStorageResponse.getUrl());
        picture.setCloudinaryId(fileStorageResponse.getId());
        picture.setOriginalName(originName);
        return pictureRepository.save(picture);
    }


    @Override
    public void deletePicture(Integer id) {
        Picture picture = this.get(id);
        fileStorageService.deleteFile(picture.getCloudinaryId());
        pictureRepository.delete(picture);
    }

    @Override
    public Picture getPicture(Integer id) {
        return this.get(id);
    }
    private Picture get(Integer id){
         return  pictureRepository.findById(id).orElseThrow(
                () -> new PictureNotFoundException(id)
        );
    }
}
