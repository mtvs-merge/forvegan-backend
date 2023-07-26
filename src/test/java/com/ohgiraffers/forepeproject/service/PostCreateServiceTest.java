package com.ohgiraffers.forepeproject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ohgiraffers.forepeproject.post.command.application.controller.PostCreateController;
import com.ohgiraffers.forepeproject.post.command.application.dto.PostCreateDTO;
import com.ohgiraffers.forepeproject.post.command.application.service.PostCreateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = com.ohgiraffers.ForepeApplication.class)
public class PostCreateServiceTest {

    @Autowired
    private PostCreateService postCreateService;

    @DisplayName("게시물 생성 테스트")
    @Test
    public void testCreatePost() {
        // Given
        PostCreateDTO createDTO = new PostCreateDTO();
        createDTO.setPostName("테스트 게시물");
        createDTO.setPostDetail("테스트 게시물 상세 내용");

        // When
        PostCreateController.Post createdPost = postCreateService.createPost(createDTO);

        // Then
        assertEquals("테스트 게시물", createdPost.getPostName());
        assertEquals("테스트 게시물 상세 내용", createdPost.getPostDetail());
    }
}
