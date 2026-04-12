package com.blog.blogrbac_system.event.notificationEvent;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class ArticleUpdateEvent {

    private Integer userId;
    private String title;
}
