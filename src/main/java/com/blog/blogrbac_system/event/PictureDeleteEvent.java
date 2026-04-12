package com.blog.blogrbac_system.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PictureDeleteEvent {

    private Integer pictureId;
}
