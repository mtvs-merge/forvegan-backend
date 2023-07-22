package com.ohgiraffers.forepeproject.post.command.application.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohgiraffers.forepeproject.post.command.application.dto.PostDTO;
import com.ohgiraffers.forepeproject.post.command.application.dto.PostDeleteDTO;
import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.PostEntity;
import com.ohgiraffers.forepeproject.post.command.domain.repository.PostRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PostModifyService {

    private final PostRepository postRepository;

    @Autowired
    public PostModifyService(PostRepository postRepository) { this.postRepository = postRepository; }

    @Transactional
    public void modifyAll(PostEntity postEntity) {

        postRepository.save(postEntity);
        postRepository.flush();
    }
}
