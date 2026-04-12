package com.blog.blogrbac_system.exception.exceptions;

import com.blog.blogrbac_system.exception.AppException;
import com.blog.blogrbac_system.exception.ErrorCode;

public class GeneralException extends AppException {

    public GeneralException(String message) {
        super(ErrorCode.FILE_NOT_FOUND, message);
    }
}
