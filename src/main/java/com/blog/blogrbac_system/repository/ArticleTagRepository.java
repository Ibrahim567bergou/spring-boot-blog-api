package com.blog.blogrbac_system.repository;

import com.blog.blogrbac_system.entity.Article;
import com.blog.blogrbac_system.entity.ArticleTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleTagRepository extends JpaRepository<ArticleTag, Integer> {

    void deleteAllByFkidArticle(Article article);
}
