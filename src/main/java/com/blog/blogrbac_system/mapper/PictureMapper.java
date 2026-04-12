package com.blog.blogrbac_system.mapper;


import com.blog.blogrbac_system.dto.response.PictureResponse;
import com.blog.blogrbac_system.entity.Picture;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@Getter
@AllArgsConstructor
public class PictureMapper implements Function<Picture, PictureResponse> {

    @Override
    public PictureResponse apply(Picture picture) {
        return new PictureResponse(
                picture.getId(),
                picture.getCloudinaryId(),
                picture.getUrl(),
                picture.getOriginalName(),
                picture.getExtension(),
                picture.getUploadAt()
        );
    }
}
