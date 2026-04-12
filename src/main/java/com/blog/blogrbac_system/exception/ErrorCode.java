package com.blog.blogrbac_system.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    USER_NOT_FOUND(404),
    CATEGORY_NOT_FOUND(404),
    TAG_NOT_FOUND(404),
    ARTICLE_NOT_FOUND(404),

    // conf
    ALREADY_EXIST(409),
    ACCESS_DENIED(403),
    VALIDATION_ERROR(400),

    // error server
    INTERNAL_ERROR(500),


    // Upload file Exception
    FILE_NOT_FOUND(404),
    FILE_EXTENSION_NOT_ALLOWED(415),
    FILE_MAX_SIZE_EXCEEDED(413),
    FILE_NOT_READABLE(500),
    FILE_NOT_UPLOADED(500),

    // Notification To User
    NOTIFICATION_NOT_FOUND(404);


    private final int status;
}
