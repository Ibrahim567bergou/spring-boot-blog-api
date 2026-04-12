package com.blog.blogrbac_system.mapper;


import com.blog.blogrbac_system.dto.response.NotificationResponse;
import com.blog.blogrbac_system.entity.Notification;
import org.springframework.cglib.core.internal.Function;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapper implements Function<Notification, NotificationResponse> {

    @Override
    public NotificationResponse apply(Notification notification) {
        return  NotificationResponse.builder()
                .id(notification.getId())
                .message(notification.getMessage())
                .type(notification.getType())
                .isRead(notification.isRead())
                .createdAt(notification.getCreateAt())
                .fkidUser(notification.getFkidUser().getId())
                .build();
    }
}
