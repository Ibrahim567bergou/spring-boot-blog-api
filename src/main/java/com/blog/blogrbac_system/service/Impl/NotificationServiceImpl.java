package com.blog.blogrbac_system.service.Impl;

import com.blog.blogrbac_system.constant.NotificationType;
import com.blog.blogrbac_system.dto.response.NotificationResponse;
import com.blog.blogrbac_system.entity.Notification;
import com.blog.blogrbac_system.entity.User;
import com.blog.blogrbac_system.exception.exceptions.NotificationNotFoundException;
import com.blog.blogrbac_system.exception.exceptions.UserNotFoundException;
import com.blog.blogrbac_system.mapper.NotificationMapper;
import com.blog.blogrbac_system.repository.NotificationRepository;
import com.blog.blogrbac_system.repository.UserRepository;
import com.blog.blogrbac_system.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;
    private final NotificationMapper notificationMapper;


    @Override
    public NotificationResponse sendNotification(Map<String, Object> params) {
        String message = (String) params.get("message");
        NotificationType type = (NotificationType) params.get("type");
        Notification notification = Notification.builder()
                .message(message)
                .type(type)
                .createAt(Instant.now())
                .isRead(false)
                .fkidUser(this.getUser(1))
                .build();
        return notificationMapper.apply(notificationRepository.save(notification));
    }


    @Override
    public void deleteNotification(Integer id) {
        notificationRepository.delete(this.get(id));
    }

    @Override
    public List<NotificationResponse> getAllNotificationByUserConnectedNotRead() { //TODO getAll Notification By UserConnected
        return List.of();
    }

    @Override
    public void markAsRead(Integer id) {  // TODO check if userConnected have permission to readNotification
        Notification notification = this.get(id);
        if(notification != null){
            notification.setRead(true);
            notificationRepository.save(notification);
        }
    }

    private Notification get(Integer id){
        return notificationRepository.findById(id).orElseThrow(
                () -> new NotificationNotFoundException(id)
        );
    }
    private User getUser(Integer id){
        return userRepository.findById(1).orElseThrow(
                () -> new UserNotFoundException(1)
        );
    }
}
