package com.example.springBootProject.web.dto;

import com.example.springBootProject.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.PrimitiveIterator;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entity){
        this.id=entity.getId();
        this.title=entity.getTitle();
        this.author=entity.getAuthor();
        this.modifiedDate=entity.getModifiedDate();

    }
}
