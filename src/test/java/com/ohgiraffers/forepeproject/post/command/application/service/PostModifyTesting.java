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

import java.time.LocalTime;
import java.util.stream.Stream;

@SpringBootTest
public class PostModifyTesting {

    @Autowired
    private PostModifyService postModifyService;


    @DisplayName("post modify test")
    @ParameterizedTest
    void testModifyPost() {
        PostDTO postDTO = new PostDTO();

        postDTO.setPostName("lsafasd");
        postDTO.setPostWriter("dsfa");
        postDTO.setPostDetail("lastjoweitj");
        postDTO.setPostCategoryNum(1);


        postModifyService.updatePost(postDTO);

    }

}
