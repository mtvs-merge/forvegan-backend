package com.ohgiraffers.forepeproject.service;

import com.ohgiraffers.forepeproject.comment.command.application.dto.CommentDTO;
import com.ohgiraffers.forepeproject.comment.command.application.service.CommentService;
import com.ohgiraffers.forepeproject.comment.command.domain.aggregate.entity.CommentEntity;
import com.ohgiraffers.forepeproject.comment.command.domain.repository.CommentsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class CommentServiceTest {
    @Test
    @DisplayName("댓글 생성 테스트")
    public void testCreateComment() {
        // Given
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setCommentWriter("rachaz");
        commentDTO.setComments("댓글 생성 테스트입니다.");

        CommentsRepository commentsRepository = new CommentsRepository();
        CommentService commentService = new CommentService(commentsRepository);

        // When
        CommentEntity savedComment = commentService.createComment(commentDTO);

        // Then
//        commentService.createComment(commentWriter);
    }



    @Test
    @DisplayName("댓글 조회 테스트")
    public void testReadComment(){

        // Given
        Long commentNum = 1L;

        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setCommentNum(1);
        commentEntity.setCommentWriter("rachaz");
        commentEntity.setCommentDetail("댓글 조회를 테스트 해볼게요");

        CommentsRepository commentsRepository = mock(CommentsRepository.class);
        when(commentsRepository.findById()).thenReturn(java.util.Optional.of(commentEntity));

        CommentService commentService = new CommentService(commentsRepository);

        // when
        commentService.readComment(commentNum);

        // then
        // 댓글 조회 코드 작성
    }

    @Test
    @DisplayName("댓글 수정 테스트")
    public void testUpdateComment() {
        // Given
        Long commentNum = 1L;

        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setCommentWriter("rachaz");
        commentEntity.setCommentDetail("수정 될 댓글입니다.");
        commentEntity.setCommentNum(3);

        CommentsRepository commentsRepository = mock(CommentsRepository.class);
        when(commentsRepository.findById()).thenReturn(java.util.Optional.of(commentEntity));

        CommentService commentService = new CommentService(commentsRepository);

        // When

        commentService.updateComment(commentNum);

        // Then
        // 수정 테스트코드 작성

    }

    @Test
    @DisplayName("댓글 삭제 테스트")
    public void testDeleteComment() {
        // Given
        Long commentId = 1L;

        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setCommentId(commentId); // 수정된 부분: commentId 설정
        commentEntity.setCommentWriter("John");
        commentEntity.setCommentDetail("This is a comment.");

        CommentsRepository commentsRepository = mock(CommentsRepository.class);
        when(commentsRepository.findById()).thenReturn(java.util.Optional.of(commentEntity));

        CommentService commentService = new CommentService(commentsRepository);

        // When
        commentService.deleteComment(commentId);


        // Then
        verify(commentsRepository, times(1)).delete(commentEntity);
    }

    @Test
    @DisplayName("댓글 조회 실패 테스트")
    public void testReadCommentNotFound() {
        // Given
        Long commentId = 1L;

        CommentsRepository commentsRepository = mock(CommentsRepository.class);
        when(commentsRepository.findById()).thenReturn(java.util.Optional.empty());

        CommentService commentService = new CommentService(commentsRepository);

        // When, Then
        assertThrows(EntityNotFoundException.class, () -> commentService.readComment(commentId));
    }

    @Test
    @DisplayName("댓글 수정 실패 테스트")
    public void testUpdateCommentNotFound() {
        // Given
        Long commentId = 1L;
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setCommentWriter("John");

        commentDTO.setComments("This is an updated comment.");

        CommentsRepository commentsRepository = mock(CommentsRepository.class);
        when(commentsRepository.findById()).thenReturn(java.util.Optional.empty());

        CommentService commentService = new CommentService(commentsRepository);

        // When, Then
        assertThrows(EntityNotFoundException.class, () -> commentService.updateComment(commentId, commentDTO));
    }

    @Test
    @DisplayName("댓글 삭제 실패 테스트")
    public void testDeleteCommentNotFound() {
        // Given
        Long commentId = 1L;

        CommentsRepository commentsRepository = mock(CommentsRepository.class);
        when(commentsRepository.findById()).thenReturn(java.util.Optional.empty());

        CommentService commentService = new CommentService(commentsRepository);

        // When, Then
        assertThrows(EntityNotFoundException.class, () -> commentService.deleteComment(commentId));
    }
}
