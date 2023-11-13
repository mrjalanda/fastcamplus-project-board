package com.fastcamplus.projectboard.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString
@Entity
@Table(name = "article", indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")

})
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //게시글 고유번호

    @Setter
    @Column(nullable = false)
    private String title; //제목

    @Setter
    @Column(nullable = false, length = 10000)
    private String content; //내용

    @Setter
    private String hashtag; //해시 태그

    @ToString.Exclude //Tostring
    //@OrderBy("id")
    @OneToMany(mappedBy = "article")
    private final Set<ArticleComment> articleComments = new HashSet<>();

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt; //작성일

    @CreatedBy
    @Column(nullable = false)
    private String createdBy; //작성자

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime modifiedAt; //수정일

    @LastModifiedBy
    @Column(nullable = false)
    private String modifiedBy; //수정자

    protected  Article(){

    }

    private  Article (String title, String content, String hashtag) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }

    public static Article of(String title, String content, String hashtag) {
        return new Article(title, content, hashtag);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Article article = (Article) object;
        return id != null && Objects.equals(id, article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
