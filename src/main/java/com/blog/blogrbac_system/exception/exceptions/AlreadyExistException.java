package com.blog.blogrbac_system.exception.exceptions;

import com.blog.blogrbac_system.exception.AppException;
import com.blog.blogrbac_system.exception.ErrorCode;

public class AlreadyExistException extends AppException {

    public AlreadyExistException(String entityName, String value){
        super(ErrorCode.ALREADY_EXIST, entityName + " with value " + value + " already exists");
    }
}
