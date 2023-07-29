//package com.ohgiraffers.forepeproject.comment.command.application.controller;
//
//import com.ohgiraffers.forepeproject.comment.command.application.service.CommentLikeService;
//import org.apache.ibatis.javassist.NotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/comments")
//public class CommentLikeController {
//
//    private final CommentLikeService commentLikeService;
//
//    @Autowired
//    public CommentLikeController(CommentLikeService commentLikeService) {
//        this.commentLikeService = commentLikeService;
//    }
//
//    // 댓글에 공감을 추가하는 엔드포인트
//    @PutMapping("/{commentId}/like")
//    public ResponseEntity<String> likeComment(@PathVariable Long commentId) throws NotFoundException {
//        commentLikeService.likeComment(commentId);
//        return ResponseEntity.ok("댓글을 공감하였습니다.");
//    }
//
//    // 댓글에 공감을 취소하는 엔드포인트
//    @DeleteMapping("/{commentId}/like")
//    public ResponseEntity<String> unlikeComment(@PathVariable Long commentId) throws NotFoundException {
//        commentLikeService.unlikeComment(commentId);
//        return ResponseEntity.ok("댓글 공감을 취소하였습니다.");
//    }
//}
