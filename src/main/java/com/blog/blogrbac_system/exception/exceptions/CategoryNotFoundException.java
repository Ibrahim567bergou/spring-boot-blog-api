package com.blog.blogrbac_system.exception.exceptions;

import com.blog.blogrbac_system.exception.AppException;
import com.blog.blogrbac_system.exception.ErrorCode;

public class CategoryNotFoundException extends AppException {

        public CategoryNotFoundException(Integer id){
            super(ErrorCode.CATEGORY_NOT_FOUND, "Category "+id+" not found");
        }

}
