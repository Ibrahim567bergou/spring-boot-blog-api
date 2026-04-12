package com.blog.blogrbac_system.exception.exceptions;

import com.blog.blogrbac_system.exception.AppException;
import com.blog.blogrbac_system.exception.ErrorCode;

public class NotificationNotFoundException extends AppException {

    public NotificationNotFoundException(Integer id) {
        super(ErrorCode.NOTIFICATION_NOT_FOUND, "Notification " + id + " not found");
    }
}
