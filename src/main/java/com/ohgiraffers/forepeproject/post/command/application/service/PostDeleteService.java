package com.ohgiraffers.forepeproject.post.command.application.service;

import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.enumType.ResponesEnum;
import com.ohgiraffers.forepeproject.post.command.domain.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostDeleteService {

    private final PostRepository postRepository;

    @Autowired
    public PostDeleteService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public ResponesEnum deletePost(Long postNum) {
        try {
            postRepository.deleteById(postNum);
            return ResponesEnum.SUCCESS;
        } catch (Exception exception) {         // 데이터 없을 시 에러?
            return ResponesEnum.FAILURE;
        }
    }
}
