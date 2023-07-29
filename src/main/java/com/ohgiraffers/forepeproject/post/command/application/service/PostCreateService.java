package com.ohgiraffers.forepeproject.post.command.application.service;

import com.ohgiraffers.forepeproject.post.command.application.controller.PostCreateController;
import com.ohgiraffers.forepeproject.post.command.application.dto.PostCreateDTO;
import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.PostEntity;
import com.ohgiraffers.forepeproject.post.command.domain.repository.PostRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
public class PostCreateService {
    private final PostRepository postRepository;

    public PostCreateService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void createPost(PostEntity postEntity) {
        PostEntity post = new PostEntity();
        post.setPostName(postEntity.getPostName());
        post.setPostDetail(postEntity.getPostDetail());

        postRepository.save(post);
        postRepository.flush();
    }
}

