package com.blog.blogrbac_system.service.Impl;

import com.blog.blogrbac_system.dto.response.FileStorageResponse;
import com.blog.blogrbac_system.exception.exceptions.GeneralException;
import com.blog.blogrbac_system.service.FileStorageService;
import com.blog.blogrbac_system.utils.FileUtil;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


@Service
public class FileStorageServiceImpl implements FileStorageService {

    @Resource
    private Cloudinary cloudinary;

    @Value("${UPLOAD_PICTURE_FILE}")
    private String uploadFileFolder;

    private final long MAX_SIZE_PICTURE = 10 * 1024 * 1024;
    private final long MAX_SIZE_AVATAR = 2 * 1024 * 1024;
    private static final Set<String> IMAGE_EXTENSIONS = Set.of("jpg", "jpeg", "png");


    @Override
    public FileStorageResponse uploadFile(MultipartFile file) {
        if(!file.isEmpty()){
            if(file.getSize() < MAX_SIZE_PICTURE){
                if(file.getResource().isReadable()){
                    String fileExtension = FileUtil.getFileExtension(Objects.requireNonNull(file.getOriginalFilename()));
                    if(!IMAGE_EXTENSIONS.contains(fileExtension)){
                        throw new GeneralException("Extension not allowed");
                    }
                    try{
                        Map<String, Object> options = new HashMap<>();
                        options.put("folder", uploadFileFolder);
                        Map uploadFile = cloudinary.uploader().upload(file.getBytes(), options);
                        String url = (String) uploadFile.get("secure_url");
                        String publicId = (String) uploadFile.get("public_id");
                        return new FileStorageResponse(publicId, url);
                    }catch (Exception e){
                        throw new GeneralException("Internal error, file not uploaded");
                    }
                }else{
                    throw  new GeneralException("File is not readable");
                }
            }else{
                throw new GeneralException("Max file's size exceeded: " + MAX_SIZE_PICTURE + "MB");
            }
        }else{
            throw new GeneralException("File not exist");
        }
    }


    @Override
    public void deleteFile(String picturePublicId) {
        try{
            Map result = cloudinary.uploader().destroy(
                    picturePublicId,
                    ObjectUtils.asMap("resource_type", "image", "invalidate", true)
            );
            if(!"ok".equals(result.get("result"))){
                throw new GeneralException("Failed to delete file: " + result.get("result"));
            }
        }catch(Exception e){
            throw new GeneralException("Internal error while deleting file");
        }

    }
}
