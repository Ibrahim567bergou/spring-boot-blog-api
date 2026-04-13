package com.blog.blogrbac_system.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;


@Getter
@AllArgsConstructor
public class ArticleCreateRequest {

    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "Content is required")
    private String content;
    @NotNull(message = "Picture is required")
    private MultipartFile picture;
    @NotBlank(message = "Status is required")
    private String statusArticle;
    @NotBlank(message = "Category is required")
    private String category;
    @Size(min = 1, message = "At least one tag is required")
    private List<String> tags;

}
