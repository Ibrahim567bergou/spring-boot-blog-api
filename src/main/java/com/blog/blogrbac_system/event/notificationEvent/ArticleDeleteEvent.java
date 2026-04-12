package com.blog.blogrbac_system.event.notificationEvent;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ArticleDeleteEvent {

    private Integer userId;
    private String title;
}
