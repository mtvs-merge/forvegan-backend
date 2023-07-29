package com.ohgiraffers.forepeproject.like.command.application.controller;

import com.ohgiraffers.forepeproject.like.command.application.dto.CommentLikeDTO;
import com.ohgiraffers.forepeproject.like.command.application.service.CommentLikeService;
import com.ohgiraffers.forepeproject.like.command.domain.aggregate.entity.CommentLikeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component("commentLikeControllerLike")
@RestController
public class CommentLikeController {

    private final CommentLikeService commentLikeService;

    @Autowired
    public CommentLikeController(CommentLikeService commentLikeService) {
        this.commentLikeService = commentLikeService;
    }


    // 추가
    @PostMapping("/comment/like")
    public void addCommentLike(@RequestBody CommentLikeDTO commentLikeDTO) {
        commentLikeService.addCommentLike(commentLikeDTO);
    }


    // 삭제
    @DeleteMapping("/comment/like/{commentLikeNum}")
    public void removeCommentLike(@PathVariable int commentLikeNum) {
        commentLikeService.removeCommentLike(commentLikeNum);
    }

    // 조회
    @GetMapping("/comment/like/{commentLikeNum}")
    public CommentLikeEntity getCommentLike(@PathVariable int commentLikeNum) {
        return commentLikeService.getCommentLike(commentLikeNum);
    }


}
