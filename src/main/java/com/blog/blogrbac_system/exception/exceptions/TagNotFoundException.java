package com.blog.blogrbac_system.exception.exceptions;

import com.blog.blogrbac_system.exception.AppException;
import com.blog.blogrbac_system.exception.ErrorCode;

public class TagNotFoundException extends AppException {

    public TagNotFoundException(Integer id){
        super(ErrorCode.TAG_NOT_FOUND, "Tag "+id+" not found");
    }
}
