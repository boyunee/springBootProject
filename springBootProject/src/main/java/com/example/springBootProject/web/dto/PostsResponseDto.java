package com.example.springBootProject.web.dto;

import com.example.springBootProject.domain.posts.Posts;
import com.example.springBootProject.domain.posts.PostsRepository;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();

    }
}
