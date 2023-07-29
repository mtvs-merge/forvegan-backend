package com.ohgiraffers.forepeproject.post.command.application.service;

import com.ohgiraffers.forepeproject.post.command.application.dto.PostDTO;
import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.PostEntity;
import com.ohgiraffers.forepeproject.post.command.domain.repository.PostRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PostModifyService {

    private final PostRepository postRepository;

    PostModifyService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public boolean verifyOwner(PostDTO postDTO) {

        if(postDTO.getPostMemberNum() == postRepository.findByPostNum(postDTO.getPostNum()).getPostMemberNum()) {
            return true;
        } else {
            return false;
        }

    }

    public void updatePost(PostDTO postDTO) {
        PostEntity postEntity = new PostEntity();

        BeanUtils.copyProperties(postDTO, postEntity);

        postRepository.save(postEntity);
    }
}
