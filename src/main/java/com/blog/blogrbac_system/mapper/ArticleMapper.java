package com.blog.blogrbac_system.mapper;


import com.blog.blogrbac_system.dto.response.ArticleResponse;
import com.blog.blogrbac_system.dto.response.PictureResponse;
import com.blog.blogrbac_system.dto.response.TagArticleResponse;
import com.blog.blogrbac_system.entity.Article;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.function.Function;

@Component
@AllArgsConstructor
public class ArticleMapper implements Function<Article, ArticleResponse> {

    private final TagArticleMapper tagArticleMapper;
    private final PictureMapper pictureMapper;

    @Override
    public ArticleResponse apply(Article article) {
        List<TagArticleResponse> tagArticleResponses = article.getArticleTag()
                .stream()
                .map(tagArticleMapper)
                .toList();
        return new ArticleResponse(
                article.getId(),
                article.getTitle(),
                article.getContent(),
                pictureMapper.apply(article.getFkidPicture()),
                article.getViewed(),
                article.getLikedCount(),
                article.getCreatedAt(),
                article.getUpdateAt(),
                article.getStatusArticle(),
                article.getFkidUser().getId(),
                article.getFkidCategory() != null ? article.getFkidCategory().getId() : null,
                tagArticleResponses
        );
    }
}
