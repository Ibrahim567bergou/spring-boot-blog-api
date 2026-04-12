package com.blog.blogrbac_system.dto.request;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleUpdateRequest {

    @NotNull(message = "Article ID is required")
    private Integer id;
    private String title;
    private String content;
    private MultipartFile picture;
    private String statusArticle;
    private String category;
    private List<String> tags;
}
