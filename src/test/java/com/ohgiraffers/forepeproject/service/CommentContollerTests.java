package com.ohgiraffers.forepeproject.service;

import com.ohgiraffers.forepeproject.comment.command.application.dto.CommentDTO;
import com.ohgiraffers.forepeproject.comment.command.application.service.CommentService;
import com.ohgiraffers.forepeproject.comment.command.domain.aggregate.entity.CommentEntity;
import com.ohgiraffers.forepeproject.comment.command.domain.repository.CommentsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CommentContollerTests {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentsRepository commentsRepository;

    @Test
    public void testCreateComment() {
        // Given
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setComments("Test comment");

        // When
        CommentEntity createdComment = (CommentEntity) commentService.createComment(commentDTO);

        // Then
        assertThat(createdComment.getCommentWriter()).isNotNull();
        assertThat(createdComment.getCommentDetail()).isEqualTo("Test comment");
    }

    // 추가적인 테스트 케이스 작성 (read, update, delete) 가능
}
