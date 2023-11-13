package com.fastcamplus.projectboard.domain;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class Article {

    private Long id; //게시글 고유번호
    private String title; //제목
    private String content; //내용
    private String hashtag; //해시 태그
    private LocalDateTime createdAt; //작성일
    private String createdBy; //작성자
    private LocalDateTime modifiedAt; //수정일
    private String modifiedBy; //수정자

}
