package com.blog.blogrbac_system.exception.exceptions;

import com.blog.blogrbac_system.exception.AppException;
import com.blog.blogrbac_system.exception.ErrorCode;

public class PictureNotFoundException extends AppException {

    public PictureNotFoundException(Integer id) {
        super(ErrorCode.FILE_NOT_FOUND, "Picture id " + id + " not found");
    }
}
