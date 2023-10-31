package com.example.multimodule;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {

    private final PostRepository postRepository;

    @Transactional
    public List<PostDto> getPostList() {
        List<Post> postList = postRepository.findAll();
        return postList.stream().map(PostDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void writePost(PostDto postDto) {
        Post post = Post.builder()
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .build();
        postRepository.save(post);
    }

    @Transactional
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Transactional
    public void modifyPost(PostDto postDto, Long id) {
        Post post = postRepository.findById(id).orElseThrow(RuntimeException::new);
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
    }
}
