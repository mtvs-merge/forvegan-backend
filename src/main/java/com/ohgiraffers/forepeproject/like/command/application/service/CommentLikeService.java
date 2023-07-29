package com.ohgiraffers.forepeproject.like.command.application.service;

import com.ohgiraffers.forepeproject.like.command.application.dto.CommentLikeDTO;
import com.ohgiraffers.forepeproject.like.command.domain.aggregate.entity.CommentLikeEntity;
import com.ohgiraffers.forepeproject.like.command.domain.repository.CommentLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentLikeService {

    private final CommentLikeRepository commentLikeRepository;

    @Autowired
    public CommentLikeService(CommentLikeRepository commentLikeRepository) {
        this.commentLikeRepository = commentLikeRepository;
    }


    // 추가
    public void addCommentLike(int commentNum, String commentWriter) {
        CommentLikeEntity commentLikeEntity = new CommentLikeEntity();
        commentLikeEntity.setCommentNum(commentNum);
        commentLikeEntity.setCommentWriter(commentWriter);
        commentLikeRepository.save(commentLikeEntity);
    }

    // 삭제
    public void removeCommentLike(int commentLikeNum) {
        commentLikeRepository.deleteById(commentLikeNum);
    }


    // 조회
    public CommentLikeEntity getCommentLike(int commentLikeNum) {
        return commentLikeRepository.findById(commentLikeNum).orElse(null);
    }

    public void addCommentLike(CommentLikeDTO commentLikeDTO) {

    }
}
