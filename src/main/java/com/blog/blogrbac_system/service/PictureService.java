package com.blog.blogrbac_system.service;

import com.blog.blogrbac_system.dto.response.PictureResponse;
import com.blog.blogrbac_system.entity.Picture;
import org.springframework.web.multipart.MultipartFile;

public interface PictureService {

    Picture uploadPicture(MultipartFile file);
    Picture getPicture(Integer id);
    void deletePicture(Integer id);


}
