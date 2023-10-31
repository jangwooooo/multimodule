package com.example.multimodule;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final Service service;

    @GetMapping
    public ResponseEntity<List<PostDto>> get() {
        List<PostDto> postDtoList = service.getPostList();
        return ResponseEntity.ok().body(postDtoList);
    }

    @PostMapping
    public ResponseEntity<Void> post(@RequestBody PostDto postDto) {
        service.writePost(postDto);
        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        service.deletePost(id);
        return ResponseEntity.ok().body(null);
    }

    @PutMapping
    public ResponseEntity<Void> put(@RequestBody PostDto postDto, @RequestParam Long id) {
        service.modifyPost(postDto, id);
        return ResponseEntity.ok().body(null);
    }
}
