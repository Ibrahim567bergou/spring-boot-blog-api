package com.blog.blogrbac_system.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class TagResponse {

    private Integer id;
    private String name;
    private String description;
    private Instant createdAt;
    private boolean isActive;
    private List<ArticleTagResponse> articles;
}
