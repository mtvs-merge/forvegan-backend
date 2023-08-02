package com.ohgiraffers.forepeproject.post.command.application.service;

import com.ohgiraffers.forepeproject.post.command.application.dto.PostDeleteDTO;
import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.PostEntity;
import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.enumType.ResponesEnum;
import com.ohgiraffers.forepeproject.post.command.domain.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
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
    public void deletePost(int postNum) {

        Optional<PostEntity> peOptional = postRepository.findById(postNum);
        PostEntity pe = peOptional.orElseThrow(() -> new IllegalArgumentException("Post not found with postNum" + postNum));

        pe.setPostState("N");

//        postRepository.save(pe);
//        postRepository.flush();

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