package com.fastcamplus.projectboard.domain;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class Article {

    private Long id;
    private String title;
    private String content;
    private String hashtag;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;

}
