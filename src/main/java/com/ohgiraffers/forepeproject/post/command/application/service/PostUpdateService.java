package com.ohgiraffers.forepeproject.post.command.application.service;

import com.ohgiraffers.forepeproject.post.command.application.dto.PostDeleteDTO;
import com.ohgiraffers.forepeproject.post.command.application.dto.PostUpdateDTO;
import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.PostEntity;
import com.ohgiraffers.forepeproject.post.command.domain.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PostUpdateService {

    private final PostRepository postRepository;

    @Autowired
    public PostUpdateService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public void UpdatePost(PostUpdateDTO postUpdateDTO) {

        PostEntity pe = postRepository.findByPostString(postUpdateDTO.getPostName());

        pe.setPostState("N");

    }

    public boolean isOwner(PostUpdateDTO postUpdateDTO) {
        PostEntity pe = postRepository.findByPostString(PostUpdateDTO.getPostName());
        if(pe.getPostMemberNum() == PostUpdateDTO.getPostMemberNum()) {
            return true;
        } else {
            return false;
        }

    }
}