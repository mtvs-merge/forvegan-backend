package com.ohgiraffers.forepeproject.service;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.ohgiraffers.forepeproject.post.command.application.controller.PostCreateController;
import com.ohgiraffers.forepeproject.post.command.application.service.PostReadService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PostReadServiceTest {

    @DisplayName("게시물 조회 테스트")
    @Test
    public void testReadPost() {
        // Given
        Long postId = 1L;

        // postReadService를 생성합니다.
        PostReadService postReadService = new PostReadService();

        // When
        PostCreateController.Post post = postReadService.readPost(postId);

        // Then
        assertNull(post);
    }
}
