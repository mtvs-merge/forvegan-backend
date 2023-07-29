package com.ohgiraffers.forepeproject.post.command.application.service;

// Service
// ㄴ @Transaction, 도메인 기능 간 순서 보장

// Create
// Read
// Update
// Delete

import com.ohgiraffers.forepeproject.post.command.domain.repository.PostsRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;



@Service
public class PostService {
    private PostsRepository postsRepository;

    // 게시글 생성

    public PostService(PostsRepository postsRepository){
        this.postsRepository = postsRepository;
    }


}
