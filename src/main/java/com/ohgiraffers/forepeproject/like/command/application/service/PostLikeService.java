package com.ohgiraffers.forepeproject.like.command.application.service;

import com.ohgiraffers.forepeproject.like.command.application.dto.PostLikeDTO;
import com.ohgiraffers.forepeproject.like.command.domain.aggregate.entity.PostLikeEntity;
import com.ohgiraffers.forepeproject.like.command.domain.repository.PostLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostLikeService {

    private final PostLikeRepository postLikeRepository;

    @Autowired
    public PostLikeService(PostLikeRepository postLikeRepository) {
        this.postLikeRepository = postLikeRepository;
    }

    // 공감 생성
    public void addPostLike(PostLikeDTO postLikeDTO) {
        // DTO를 Entity로 변환
        PostLikeEntity postLikeEntity = new PostLikeEntity();
        postLikeEntity.setPostNum(postLikeDTO.getPostNum());
        postLikeEntity.setPostWriter(postLikeDTO.getPostWriter());

        // Entity를 저장하여 데이터베이스에 공감 정보 추가
        postLikeRepository.save(postLikeEntity);
    }

    // 공감 조회
    public PostLikeEntity getPostLike(int postLikeNum) {
        // 데이터베이스에서 공감 정보 조회
        return postLikeRepository.findById(postLikeNum).orElse(null);
    }

    // 공감 삭제
    public void removePostLike(int postLikeNum) {
        // 데이터베이스에서 공감 정보 삭제
        postLikeRepository.deleteById(postLikeNum);
    }
}
