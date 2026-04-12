package com.blog.blogrbac_system.listener;


import com.blog.blogrbac_system.constant.NotificationType;
import com.blog.blogrbac_system.event.PictureDeleteEvent;
import com.blog.blogrbac_system.event.notificationEvent.ArticleCreatedEvent;
import com.blog.blogrbac_system.event.notificationEvent.ArticleDeleteEvent;
import com.blog.blogrbac_system.event.notificationEvent.ArticleUpdateEvent;
import com.blog.blogrbac_system.service.NotificationService;
import com.blog.blogrbac_system.service.PictureService;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
@AllArgsConstructor
public class ArticleListener {

    private final PictureService pictureService;
    private final NotificationService notificationService;

    @EventListener
    public void listenerCreateArticle(ArticleCreatedEvent event){
        String message = String.format(
                NotificationType.ARTICLE_CREATED.getMessage(),
                event.getTitle()
        );
        Map<String, Object> params = new HashMap<>();
        params.put("message", message);
        params.put("type", NotificationType.ARTICLE_CREATED);
        notificationService.sendNotification(params);
    }
    @EventListener
    public void listenerUpdateArticle(ArticleUpdateEvent event){
        String message = String.format(
                NotificationType.ARTICLE_UPDATED.getMessage(),
                event.getTitle()
        );
        Map<String, Object> params = new HashMap<>();
        params.put("message", message);
        params.put("type", NotificationType.ARTICLE_UPDATED);
        notificationService.sendNotification(params);
    }
    @EventListener
    public void listenerDeleteArticle(ArticleDeleteEvent event){
        String message = String.format(
                NotificationType.ARTICLE_DELETED.getMessage(),
                event.getTitle()
        );
        Map<String, Object> params = new HashMap<>();
        params.put("message", message);
        params.put("type", NotificationType.ARTICLE_DELETED);
        notificationService.sendNotification(params);
    }

    @EventListener
    public void listenerDeletePicture(PictureDeleteEvent event){
        pictureService.deletePicture(event.getPictureId());
    }
}
