package com.ohgiraffers.forepeproject.post.command.application.service;

import com.ohgiraffers.forepeproject.post.command.application.controller.PostCreateController;
import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.PostEntity;
import com.ohgiraffers.forepeproject.post.query.domain.entity.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostReadService {

    private final PostMapper postMapper;

    @Autowired
    public PostReadService(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    public PostCreateController.Post readPost(Long id) {
        return null;
    }

    public List<PostEntity> getAllPost(int page, int postCategeroyNum) {

        page = 15 * (page - 1);

        System.out.println(page);
        System.out.println(postCategeroyNum);

        return postMapper.getAllPost(page, postCategeroyNum);
    }
}
