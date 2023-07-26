package com.ohgiraffers.forepeproject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.ohgiraffers.forepeproject.post.command.application.service.PostDeleteService;
import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.enumType.ResponesEnum;
import com.ohgiraffers.forepeproject.post.command.domain.repository.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PostDeleteServiceTest {

    @DisplayName("게시물 삭제 테스트")
    @Test
    public void testDeletePost() {
        // Given
        Long postNum = 1L;

        // postRepository를 Mock으로!
        PostRepository postRepository = Mockito.mock(PostRepository.class);
        PostDeleteService postDeleteService = new PostDeleteService(postRepository);

        // When
        ResponesEnum result = postDeleteService.deletePost(postNum);

        // Then
        assertEquals(ResponesEnum.SUCCESS, result);

        // postRepository의 deleteById 메서드가 1번 호출되었는지 확인합니다.
        Mockito.verify(postRepository, Mockito.times(1)).deleteById(postNum);
    }
}
