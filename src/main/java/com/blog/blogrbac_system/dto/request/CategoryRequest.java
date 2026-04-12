package com.blog.blogrbac_system.dto.request;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequest {

    private Integer id;
    @NotNull(message = "Category name is required")
    @Size(min = 3 , max = 30)
    private String name;
    private String description;
}
