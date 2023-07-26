package com.ohgiraffers.forepeproject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ohgiraffers.forepeproject.post.command.application.service.PostUpdateService;
import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.enumType.ResponesEnum;
import com.ohgiraffers.forepeproject.post.command.domain.repository.PostsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PostUpdateServiceTest {

    @DisplayName("게시물 업데이트 테스트")
    @Test
    public void testUpdatePost() {
        // Given
        Long postNum = 1L;

        PostsRepository postsRepository = Mockito.mock(PostsRepository.class);
        PostUpdateService postUpdateService = new PostUpdateService(postsRepository);

        // When
        ResponesEnum result = postUpdateService.updatePost(postNum, postNum);

        // Then
        assertEquals(ResponesEnum.SUCCESS, result);

        // postsRepository의 findById 메서드가 1번 호출되었는지 확인
        Mockito.verify(postsRepository, Mockito.times(1)).findById(postNum);
    }
}
