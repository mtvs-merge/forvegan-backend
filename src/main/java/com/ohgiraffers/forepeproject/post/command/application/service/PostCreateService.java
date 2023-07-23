package com.ohgiraffers.forepeproject.post.command.application.service;

import com.ohgiraffers.forepeproject.post.command.application.controller.PostCreateController;
import com.ohgiraffers.forepeproject.post.command.application.dto.PostCreateDTO;
import com.ohgiraffers.forepeproject.post.command.domain.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostCreateService {
    private final PostRepository postRepository;

    public PostCreateService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostCreateController.Post createPost(PostCreateDTO createDTO) {
        PostCreateController.Post post = new PostCreateController.Post();
        post.setPostName(createDTO.getPostName());
        post.setPostDetail(createDTO.getPostDetail());

        return postRepository.save(post);
    }
}

