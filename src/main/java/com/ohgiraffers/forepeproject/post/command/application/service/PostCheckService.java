package com.ohgiraffers.forepeproject.post.command.application.service;

import com.ohgiraffers.forepeproject.post.command.application.controller.PostCheckController;
import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.PostEntity;
import com.ohgiraffers.forepeproject.post.command.domain.repository.PostRepository;
import com.ohgiraffers.forepeproject.post.query.domain.entity.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostCheckService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Autowired
    public PostCheckService(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    public List<PostEntity> getAllPosts() {
        return postRepository.findAll();
    }

    public PostCheckController.Post save(PostCheckController.Post post) {
        return null;
    }

    public PostEntity checkPost(int postNum) {

        PostEntity postEntity = postMapper.getPostDetails(postNum);

        postEntity.setViews(postEntity.getViews() + 1);
        postRepository.save(postEntity);

        return postEntity;
    }
}