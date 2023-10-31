package com.example.multimodule;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostDto {

    String title;
    String content;

    public PostDto(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
    }
}
