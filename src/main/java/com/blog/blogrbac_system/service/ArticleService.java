package com.blog.blogrbac_system.service;

import com.blog.blogrbac_system.dto.request.ArticleCreateRequest;
import com.blog.blogrbac_system.dto.request.ArticleUpdateRequest;
import com.blog.blogrbac_system.dto.response.ArticleResponse;
import java.util.List;

public interface ArticleService {

    ArticleResponse createArticle(ArticleCreateRequest request);
    ArticleResponse updateArticle(ArticleUpdateRequest request);
    void deleteArticle(Integer id);
    ArticleResponse getById(Integer id);
    List<ArticleResponse> getAllArticle();
    ArticleResponse searchArticle(String keyword);
}
