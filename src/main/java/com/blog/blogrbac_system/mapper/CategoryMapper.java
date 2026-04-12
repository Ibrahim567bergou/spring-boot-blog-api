package com.blog.blogrbac_system.mapper;


import com.blog.blogrbac_system.dto.response.ArticleResponseMini;
import com.blog.blogrbac_system.dto.response.CategoryResponse;
import com.blog.blogrbac_system.entity.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
@AllArgsConstructor
public class CategoryMapper implements Function<Category, CategoryResponse> {

    private final ArticleMapper articleMapper;
    private final ArticleMiniMapper ArticleMiniMapper;

    @Override
    public CategoryResponse apply(Category category) {
        List<ArticleResponseMini> blogResponseMiniList = category.getArticles()
                .stream()
                .map(ArticleMiniMapper)
                .toList();
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.getCreatedAt(),
                blogResponseMiniList
        );
    }
}
