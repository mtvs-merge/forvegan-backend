package com.ohgiraffers.forepeproject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ohgiraffers.forepeproject.post.command.application.controller.PostCreateController;
import com.ohgiraffers.forepeproject.post.command.application.dto.PostCreateDTO;
import com.ohgiraffers.forepeproject.post.command.application.service.PostCreateService;
import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.PostEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class PostCreateServiceTest {

    @Autowired
    private PostCreateService postCreateService;

    @DisplayName("게시물 생성 테스트")
    @Test
    public void testCreatePost() {
        // Given
        PostEntity postEntity = new PostEntity();
        postEntity.setPostName("테스트 게시물 제목입니다.");
        postEntity.setPostDetail("테스트 게시물 상세 내용입니다.");

        // When
        postCreateService.createPost(postEntity);

        // Then
//        assertEquals("테스트 게시물 제목 입니다.", createdPost.getPostName());
//        assertEquals("테스트 게시물 상세 내용입니다.", createdPost.getPostDetail());
    }
}
