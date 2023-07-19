package com.ohgiraffers.forepeproject.post.command.application.service;

import com.ohgiraffers.forepeproject.post.command.application.dto.PostFormDTO;
import com.ohgiraffers.forepeproject.post.query.domain.entity.PostEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Member;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    @Override
    public ResponseEntity save(PostFormDTO formDTO) {

        Optional<Member> member;
        member = memberRepository.findById(formDTO.getMemberId());

        if(member.isPresent()){
            Member memberEntity = member.get();

            PostEntity post = PostEntity.builder()
                    .postName(formDTO.getPostName())
                    .content(formDTO.getContent())
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .adminViews(0)
                    .userViews(0)
                    .likes(0)
                    .member(memberEntity)
                    .build();

    }
}
