package com.blog.blogrbac_system.service;


import com.blog.blogrbac_system.dto.response.NotificationResponse;
import java.util.List;
import java.util.Map;

public interface NotificationService {

    NotificationResponse sendNotification(Map<String, Object> params);
    void deleteNotification(Integer id);
    List<NotificationResponse> getAllNotificationByUserConnectedNotRead();
    void markAsRead(Integer notificationId);

}
