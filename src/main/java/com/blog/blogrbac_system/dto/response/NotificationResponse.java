package com.blog.blogrbac_system.dto.response;


import com.blog.blogrbac_system.constant.NotificationType;
import lombok.Builder;
import lombok.Setter;
import java.time.Instant;

@Setter
@Builder
public class NotificationResponse {

    private Integer id;
    private String message;
    private NotificationType type;
    private boolean isRead;
    private Instant createdAt;
    private Integer fkidUser;
}
