package com.ohgiraffers.forepeproject.post.command.application.controller;

import com.ohgiraffers.forepeproject.post.command.application.dto.PostCreateDTO;
import com.ohgiraffers.forepeproject.post.command.application.service.PostCreateService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/posts")
public class PostCreateController {
    private final PostCreateService postCreateService;

    public PostCreateController(PostCreateService postCreateService) {
        this.postCreateService = postCreateService;
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostCreateDTO createDTO) {
        Post createdPost = postCreateService.createPost(createDTO);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    public static class Post {
        public void setPostDetail(String postDetail) {
        }

        public void setPostName(String postName) {
        }

        public String getPostDetail() {
            return null;
        }

        public String getPostName() {
            return null;
        }
    }
}

