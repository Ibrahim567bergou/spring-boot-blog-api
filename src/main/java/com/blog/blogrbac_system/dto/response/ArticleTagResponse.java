package com.blog.blogrbac_system.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleTagResponse {

    private Integer id;
    @JsonProperty("article_id")
    private Integer article;
    private String title;
}
