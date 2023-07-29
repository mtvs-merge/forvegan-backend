package com.ohgiraffers.forepeproject.service;

//import com.ohgiraffers.forepeproject.comment.command.application.service.CommentLikeService;
import com.ohgiraffers.forepeproject.like.command.application.service.CommentLikeService;
import com.ohgiraffers.forepeproject.like.command.domain.aggregate.entity.CommentLikeEntity;
import com.ohgiraffers.forepeproject.like.command.domain.repository.CommentLikeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CommentLikeServiceTest {

    @Mock
    private CommentLikeRepository commentLikeRepository;

    @InjectMocks
    private CommentLikeService commentLikeService;

    @Test
    @DisplayName("댓글 공감 추가 테스트")
    public void testAddCommentLike() {
        // given
        int commentNum = 1;
        String commentWriter = "Alice";

        // No need to define a return value for commentLikeRepository.save()

        // when
        commentLikeService.addCommentLike(commentNum, commentWriter);

        // then
        verify(commentLikeRepository).save(Mockito.any(CommentLikeEntity.class));
    }

    @Test
    @DisplayName("댓글 공감 삭제 테스트")
    public void testRemoveCommentLike() {
        // given
        int commentLikeNum = 1;

        // No need to define a return value for commentLikeRepository.deleteById()

        // when
        commentLikeService.removeCommentLike(commentLikeNum);

        // then
        verify(commentLikeRepository).deleteById(commentLikeNum);
    }

    @Test
    @DisplayName("댓글 공감 조회 테스트")
    public void testGetCommentLike() {
        // given
        int commentLikeNum = 1;
        CommentLikeEntity commentLikeEntity = new CommentLikeEntity();
        commentLikeEntity.setCommentNum(1);
        commentLikeEntity.setCommentWriter("Alice");

        // Mocking the behavior of commentLikeRepository.findById()
        when(commentLikeRepository.findById(commentLikeNum)).thenReturn(Optional.of(commentLikeEntity));

        // when
        CommentLikeEntity result = commentLikeService.getCommentLike(commentLikeNum);

        // then
        assertNotNull(result, "CommentLikeEntity should not be null.");
        assertEquals(commentLikeEntity.getCommentNum(), result.getCommentNum(), "CommentNum should match.");
        assertEquals(commentLikeEntity.getCommentWriter(), result.getCommentWriter(), "CommentWriter should match.");
    }
}
