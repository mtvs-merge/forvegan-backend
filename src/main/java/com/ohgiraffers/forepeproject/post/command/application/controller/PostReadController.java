package com.ohgiraffers.forepeproject.post.command.application.controller;

import com.ohgiraffers.forepeproject.post.command.application.service.PostReadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostReadController {
    private final PostReadService postReadService;

    public PostReadController(PostReadService postReadService) {
        this.postReadService = postReadService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostCreateController.Post> readPost(@PathVariable Long id) {
        PostCreateController.Post post = postReadService.readPost(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
}

