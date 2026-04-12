package com.blog.blogrbac_system.controller;


import com.blog.blogrbac_system.constant.RESPONSE;
import com.blog.blogrbac_system.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${REST_NAME}/notification")
@AllArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PutMapping("/read_notification")
    public ResponseEntity<?> raedNotification(
            @RequestParam Integer id
    ){
        notificationService.markAsRead(id);
        return RESPONSE.READ_SUCCESS_NOTIFICATION();
    }
}
