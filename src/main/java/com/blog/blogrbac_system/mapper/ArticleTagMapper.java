package com.blog.blogrbac_system.mapper;


import com.blog.blogrbac_system.dto.response.ArticleTagResponse;
import com.blog.blogrbac_system.entity.ArticleTag;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.function.Function;

@Component
@AllArgsConstructor
public class ArticleTagMapper implements Function<ArticleTag, ArticleTagResponse> {

    @Override
    @Transactional
    public ArticleTagResponse apply(ArticleTag blogTag) {
        return new ArticleTagResponse(
                blogTag.getId(),
                blogTag.getFkidArticle().getId(),
                blogTag.getFkidArticle().getTitle()
        );
    }
}
