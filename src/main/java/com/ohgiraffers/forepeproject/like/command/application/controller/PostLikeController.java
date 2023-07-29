package com.ohgiraffers.forepeproject.like.command.application.controller;

import com.ohgiraffers.forepeproject.like.command.application.dto.PostLikeDTO;
import com.ohgiraffers.forepeproject.like.command.application.service.PostLikeService;
import com.ohgiraffers.forepeproject.like.command.domain.aggregate.entity.PostLikeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostLikeController {

    private final PostLikeService postLikeService;

    @Autowired
    public PostLikeController(PostLikeService postLikeService) {
        this.postLikeService = postLikeService;
    }

    // 공감 생성
    @PostMapping("/{postNum}/like")
    public ResponseEntity<String> likePost(@PathVariable int postNum, @RequestBody PostLikeDTO postLikeDTO) {
        postLikeDTO.setPostNum(postNum);
        postLikeService.addPostLike(postLikeDTO);
        return ResponseEntity.ok("게시글 공감이 성공적으로 처리되었습니다.");
    }

    // 공감 조회
    @GetMapping("/like/{postLikeNum}")
    public ResponseEntity<PostLikeEntity> getPostLike(@PathVariable int postLikeNum) {
        PostLikeEntity postLike = postLikeService.getPostLike(postLikeNum);
        if (postLike != null) {
            return ResponseEntity.ok(postLike);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 공감 삭제
    @DeleteMapping("/like/{postLikeNum}")
    public ResponseEntity<String> removePostLike(@PathVariable int postLikeNum) {
        postLikeService.removePostLike(postLikeNum);
        return ResponseEntity.ok("게시글 공감이 성공적으로 삭제되었습니다.");
    }
}
