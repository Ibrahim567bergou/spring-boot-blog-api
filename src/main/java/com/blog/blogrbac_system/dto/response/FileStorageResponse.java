package com.blog.blogrbac_system.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@AllArgsConstructor
@Getter
public class FileStorageResponse {

    @JsonProperty("id_picture_storage")
    private String id;
    @JsonProperty("url_picture")
    private String url;
}
