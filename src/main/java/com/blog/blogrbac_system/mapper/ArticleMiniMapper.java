package com.blog.blogrbac_system.mapper;


import com.blog.blogrbac_system.dto.response.ArticleResponseMini;
import com.blog.blogrbac_system.dto.response.PictureResponse;
import com.blog.blogrbac_system.dto.response.TagArticleResponse;
import com.blog.blogrbac_system.entity.Article;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.function.Function;

@Component
@AllArgsConstructor
public class ArticleMiniMapper implements Function<Article, ArticleResponseMini> {

    private final TagArticleMapper tagArticleMapper;
    private final PictureMapper pictureMapper;

    @Override
    public ArticleResponseMini apply(Article article) {
        List<TagArticleResponse> tagArticleResponseList = article.getArticleTag()
                .stream()
                .map(tagArticleMapper)
                .toList();
        return new ArticleResponseMini(
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
                tagArticleResponseList
        );
    }
}
