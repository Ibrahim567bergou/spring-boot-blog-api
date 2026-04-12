package com.blog.blogrbac_system.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AppException extends RuntimeException{

    private final ErrorCode errorCode;

    public AppException(ErrorCode errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }
}
