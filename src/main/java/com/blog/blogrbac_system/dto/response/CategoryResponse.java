package com.blog.blogrbac_system.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
public class CategoryResponse {
    private Integer id;
    private String name;
    private String description;
    private Instant createdAt;
    private List<ArticleResponseMini> articleResponseMin;
}
