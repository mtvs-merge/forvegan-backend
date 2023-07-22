package com.ohgiraffers.forepeproject.post.command.application.service;

import com.ohgiraffers.forepeproject.post.command.application.dto.PostDeleteDTO;
import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.PostEntity;
import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.enumType.ResponesEnum;
import com.ohgiraffers.forepeproject.post.command.domain.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PostDeleteService {

    private final PostRepository postRepository;

    @Autowired
    public PostDeleteService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public void deletePost(PostDeleteDTO postDeleteDTO) {

        PostEntity postEntity = postRepository.getReferenceById(postDeleteDTO.getPostNum());

        postEntity.setPostState("N");

        postRepository.save(postEntity);
        postRepository.flush();

    }

    public boolean isOwner(PostDeleteDTO postDeleteDTO) {
        PostEntity pe = postRepository.getReferenceById(postDeleteDTO.getPostNum());
        if(pe.getPostMemberNum() == postDeleteDTO.getPostMemberNum()) {
            return true;
        } else {
            return false;
        }

    }
}
