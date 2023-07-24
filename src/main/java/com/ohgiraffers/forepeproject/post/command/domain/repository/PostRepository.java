package com.ohgiraffers.forepeproject.post.command.domain.repository;


import com.ohgiraffers.forepeproject.post.command.application.controller.PostCreateController;
import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.PostEntity;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepository {

    public int getPostNum() {
        return 0;
    }

    public PostCreateController.Post save(PostCreateController.Post post) {
        return post;
    }

    public PostEntity findByPostNum(int postMemberNum) {
        return null;
    }

    public void deleteById(Long postNum) {
    }
}
