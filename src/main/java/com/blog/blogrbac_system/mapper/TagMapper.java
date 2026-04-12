package com.blog.blogrbac_system.mapper;

import com.blog.blogrbac_system.dto.response.ArticleTagResponse;
import com.blog.blogrbac_system.dto.response.TagResponse;
import com.blog.blogrbac_system.entity.Tag;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
@AllArgsConstructor
public class TagMapper implements Function<Tag, TagResponse> {

    private final ArticleTagMapper articleTagMapper;

    @Override
    public TagResponse apply(Tag tag) {
        List<ArticleTagResponse> blogTagResponseList = tag.getArticleTags()
                .stream()
                .map(articleTagMapper)
                .toList();
        return new TagResponse(
                tag.getId(),
                tag.getName(),
                tag.getDescription(),
                tag.getCreatedAt(),
                tag.isActive(),
                blogTagResponseList
        );
    }
}
