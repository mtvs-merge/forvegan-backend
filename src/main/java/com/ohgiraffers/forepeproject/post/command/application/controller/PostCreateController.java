package com.ohgiraffers.forepeproject.post.command.application.controller;

import com.ohgiraffers.forepeproject.post.command.application.dto.PostCreateDTO;
import com.ohgiraffers.forepeproject.post.command.application.service.PostCreateService;

import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.PostEntity;
import org.springframework.beans.BeanUtils;
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
    public String createPost(@RequestBody PostCreateDTO createDTO) {

        PostEntity postEntity = new PostEntity();

        BeanUtils.copyProperties(createDTO, postEntity);

        postCreateService.createPost(postEntity);
//        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
        return "redirect:/post";
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