package com.blog.blogrbac_system.dto.response;

import com.blog.blogrbac_system.constant.StatusArticle;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
public class ArticleResponseMini {

    private Integer id;
    private String title;
    private String content;
    @JsonProperty("picture_info")
    private PictureResponse picture;
    private Integer viewed;
    @JsonProperty("linked_count")
    private Integer linkedCount;
    @JsonProperty("created_date")
    private Instant createdAt;
    @JsonProperty("update_date")
    private Instant updateAt;
    @JsonProperty("status_article")
    private StatusArticle statusArticle;
    @JsonProperty("user_id")
    private Integer userID;
    @JsonProperty("tags_list")
    private List<TagArticleResponse> tags;
}
