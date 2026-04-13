package com.blog.blogrbac_system.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
public class PictureResponse {

    @JsonProperty("picture_id")
    private Integer id;
    @JsonProperty("cloudinary_id_picture")
    private String cloudinaryId;
    @JsonProperty("picture_url")
    private String pictureUrl;
    @JsonProperty("picture_name")
    private String originName;
    private String extension;
    @JsonProperty("upload_date")
    private Instant uploadAt;

}
