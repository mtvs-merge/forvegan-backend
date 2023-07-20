package com.ohgiraffers.forepeproject.post.command.application.service;

// Service
// ㄴ @Transaction, 도메인 기능 간 순서 보장

// Create
// Read
// Update
// Delete

import com.ohgiraffers.forepeproject.post.command.domain.repository.PostRepository;
import org.springframework.stereotype.Service;



@Service
public class PostService {
    private PostRepository postRepository;

    // 게시글 생성

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }


}
