package com.blog.blogrbac_system.exception.exceptions;

import com.blog.blogrbac_system.exception.AppException;
import com.blog.blogrbac_system.exception.ErrorCode;

public class ArticleNotFoundException extends AppException {

    public ArticleNotFoundException(Integer id) {
        super(ErrorCode.ARTICLE_NOT_FOUND, "Article " + id + " not found");
    }
}
