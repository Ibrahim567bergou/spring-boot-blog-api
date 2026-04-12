package com.blog.blogrbac_system.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TagArticleResponse {

    private Integer id;
    @JsonProperty("tag_id")
    private Integer tagId;
    private String name;
}
