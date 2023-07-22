package com.ohgiraffers.forepeproject.post.command.application.service;

import com.ohgiraffers.forepeproject.post.command.application.dto.PostCreateDTO;
import com.ohgiraffers.forepeproject.post.command.application.dto.PostDTO;
import com.ohgiraffers.forepeproject.post.command.domain.repository.PostRepository;
import com.ohgiraffers.forepeproject.post.command.domain.repository.PostsRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class PostCreateService {
    private PostsRepository postsRepository;


//    private static final int BLOCK_PACE_NUM_COUNT = 5; // 블럭에 존재하는 페이지 수
//    private static final int PACE_POST_COUNT = 3; // 한 페이지에 존재하는 게시글 수
//
//    public PostCreateService(PostsRepository postsRepository){
//        this.postsRepository = postsRepository;
//    }

    @Transactional
    public static int savePost(PostDTO postDTO){
        return postDTO.save(postDTO.toEntity()).getPostNum();
    }

}
