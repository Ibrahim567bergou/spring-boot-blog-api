package com.blog.blogrbac_system.dto.response;


import com.blog.blogrbac_system.constant.StatusArticle;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class ArticleResponse {

    private Integer id;
    private String title;
    private String content;
    @JsonProperty("picture_info")
    private PictureResponse picture;
    private Integer viewed;
    @JsonProperty("linked_cound")
    private Integer linkedCount;
    @JsonProperty("date_create")
    private Instant createdAt;
    @JsonProperty("date_update")
    private Instant updateAt;
    @JsonProperty("status_article")
    private StatusArticle statusArticle;
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("category_id")
    private Integer categoryId;
    @JsonProperty("tags_list")
    private List<TagArticleResponse> tags;
}
