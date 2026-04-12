package com.blog.blogrbac_system.exception.exceptions;

import com.blog.blogrbac_system.exception.AppException;
import com.blog.blogrbac_system.exception.ErrorCode;

public class UserNotFoundException extends AppException {

    public UserNotFoundException(Integer id){
        super(ErrorCode.USER_NOT_FOUND, "User " + id + " not found");
    }
}
