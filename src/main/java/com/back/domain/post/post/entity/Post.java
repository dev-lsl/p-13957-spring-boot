package com.back.domain.post.post.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity // 아래 클래스의 대한 테이블 만들어줘
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Post {
    @Id //pk
    @GeneratedValue(strategy = IDENTITY) //auto_increment
    private  int id;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private String title; //VARCHAR(255)
    @Column(columnDefinition = "TEXT")
    private String content;

    public Post(String title, String content){
        this.createDate = LocalDateTime.now();
        this.modifyDate = this.createDate;
        this.title=title;
        this.content=content;
    }

}
