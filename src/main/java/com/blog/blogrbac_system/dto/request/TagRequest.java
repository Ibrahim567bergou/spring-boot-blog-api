package com.blog.blogrbac_system.dto.request;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class TagRequest {

    @NotNull(message = "Tag name is required")
    @Size(min = 3 , max = 30)
    private String name;
    private String description;
    private boolean is_active;

}
