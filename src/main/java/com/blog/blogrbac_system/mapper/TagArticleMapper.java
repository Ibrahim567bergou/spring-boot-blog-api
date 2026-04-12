package com.blog.blogrbac_system.mapper;

import com.blog.blogrbac_system.dto.response.TagArticleResponse;
import com.blog.blogrbac_system.entity.ArticleTag;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.function.Function;

@Component
@AllArgsConstructor
public class TagArticleMapper implements Function<ArticleTag, TagArticleResponse> {

    @Override
    public TagArticleResponse apply(ArticleTag blogTag) {
        return new TagArticleResponse(
                blogTag.getId(),
                blogTag.getFkidTag().getId(),
                blogTag.getFkidTag().getName()
        );
    }
}
