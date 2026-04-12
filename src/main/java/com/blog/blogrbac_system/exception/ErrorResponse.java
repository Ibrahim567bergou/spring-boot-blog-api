package com.blog.blogrbac_system.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
@Getter
@AllArgsConstructor
public class ErrorResponse {

    private int status;
    private String errorCode;
    private String message;
    private String path;
    private Instant timestamp;
}
