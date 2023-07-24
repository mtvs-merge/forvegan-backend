package com.ohgiraffers.forepeproject.post.command.application.service;

import com.ohgiraffers.forepeproject.post.command.application.dto.PostDTO;
import com.ohgiraffers.forepeproject.post.command.application.dto.PostDeleteDTO;
import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.PostEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest
public class PostModifyTesting {

    @Autowired
    private PostModifyService postModifyService;

    private static Stream<Arguments> modifyPost() {

        return Stream.of(
                Arguments.of(
                        1,
                        "ee",
                        23,
                        "aef",
                        "ag",
                        "Y",
                        "faope",
                        "sdaiofi",
                        4,
                        2,
                        "safjlewa",
                        3
                )
        );

    }

    @DisplayName("post modify test")
    @ParameterizedTest
    @MethodSource("modifyPost")
    void testModifyPost(int postNum, String postName, int postLike, String postWriter, String postHighlight,
                        String postState, String postDate, String postDetail, int views, int postCategoryNum,
                        String attachment, int postMemberNum) {
        PostDTO postDTO = new PostDTO(
                postNum,
                postName,
                postLike,
                postWriter,
                postHighlight,
                postState,
                postDate,
                postDetail,
                views,
                postCategoryNum,
                attachment,
                postMemberNum
        );

        PostEntity postEntity = new PostEntity();

        BeanUtils.copyProperties(postDTO, postEntity);

        postModifyService.modifyAll(postEntity);

    }

}
