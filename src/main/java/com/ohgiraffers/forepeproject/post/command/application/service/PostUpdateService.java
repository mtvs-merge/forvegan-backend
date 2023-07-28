package com.ohgiraffers.forepeproject.post.command.application.service;

import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.enumType.ResponesEnum;
import com.ohgiraffers.forepeproject.post.command.domain.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostUpdateService {

    private final PostsRepository postsRepository;

    @Autowired
    public PostUpdateService(PostsRepository postsRepository){
        this.postsRepository = postsRepository;
    }

//    public ResponesEnum updatePost(Long PostNum){
//        try{
//            postsRepository.findById(postNum);
//            return ResponesEnum.SUCCESS;
//        } catch (Exception exception){
//            return ResponesEnum.FAILURE;
//        }
//    }
}
