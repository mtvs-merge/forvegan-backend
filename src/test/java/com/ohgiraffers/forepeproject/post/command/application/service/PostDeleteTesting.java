package com.ohgiraffers.forepeproject.post.command.application.service;

import com.ohgiraffers.forepeproject.post.command.application.dto.PostDeleteDTO;
import com.ohgiraffers.forepeproject.post.command.application.service.PostDeleteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest
public class PostDeleteTesting {

    @Autowired
    private PostDeleteService postDeleteService;

    private static Stream<Arguments> createPost() {
        return Stream.of(
                Arguments.of(
                        1,
                        "Y",
                        1
                ), Arguments.of(
                        2,
                        "N",
                        2
                )

        );
    }

    @DisplayName("게시판 지우기 테스트")
    @ParameterizedTest
    @MethodSource("createPost")
    void testDeletePost(int postNum, String postState, int postMemberNum) {
        PostDeleteDTO postDeleteDTO = new PostDeleteDTO(
                postNum,
                postState,
                postMemberNum
        );

        Assertions.assertDoesNotThrow(
                () -> postDeleteService.deletePost(postDeleteDTO)
        );
    }

}
