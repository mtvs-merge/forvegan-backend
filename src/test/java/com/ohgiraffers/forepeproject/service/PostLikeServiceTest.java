package com.ohgiraffers.forepeproject.service;

import com.ohgiraffers.forepeproject.like.command.application.dto.PostLikeDTO;
import com.ohgiraffers.forepeproject.like.command.application.service.PostLikeService;
import com.ohgiraffers.forepeproject.like.command.domain.aggregate.entity.PostLikeEntity;
import com.ohgiraffers.forepeproject.like.command.domain.repository.PostLikeRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
public class PostLikeServiceTest {

    @Autowired
    private PostLikeService postLikeService;

    @Autowired
    private PostLikeRepository postLikeRepository;

    private PostLikeDTO postLikeDTO;

    @BeforeEach
    public void setUp() {
        postLikeDTO = new PostLikeDTO();
        postLikeDTO.setPostNum(1);
        postLikeDTO.setPostWriter("testUser");
    }

    @Test
    @DisplayName("게시글 공감 생성 테스트")
    public void givenPostLikeDTO_whenAddPostLike_thenPostLikeEntitySaved() {
        // Given (테스트 데이터 생성)

        // When (테스트할 메서드 실행)
        postLikeService.addPostLike(postLikeDTO);

        // Then (예상 결과 확인)
        PostLikeEntity postLikeEntity = postLikeRepository.findById(1).orElse(null);
        assertThat(postLikeEntity).isNotNull();
        assertThat(postLikeEntity.getPostNum()).isEqualTo(1);
        assertThat(postLikeEntity.getPostWriter().getCommentWriter()).isEqualTo("testUser");
    }

    @Test
    @DisplayName("게시글 공감 조회 테스트")
    public void givenPostLikeEntity_whenGetPostLike_thenPostLikeEntityReturned() {
        // Given (테스트 데이터 생성)
        PostLikeEntity postLikeEntity = new PostLikeEntity();
        postLikeEntity.setPostNum(1);
        postLikeEntity.setPostWriter("testUser");
        postLikeRepository.save(postLikeEntity);

        // When (테스트할 메서드 실행)
        Optional<PostLikeEntity> result = Optional.ofNullable(postLikeService.getPostLike(1));

        // Then (예상 결과 확인)
        assertThat(result).isPresent();
        assertThat(result.get().getPostNum()).isEqualTo(postLikeEntity.getPostNum());
        assertThat(result.get().getPostWriter().getCommentWriter()).isEqualTo(postLikeEntity.getPostWriter());
    }

    @Test
    @DisplayName("존재하지 않는 게시글 공감 조회 테스트")
    public void givenNonExistingPostLike_whenGetPostLike_thenEmptyOptionalReturned() {
        // When (테스트할 메서드 실행)
        Optional<PostLikeEntity> result = Optional.ofNullable(postLikeService.getPostLike(1));

        // Then (예상 결과 확인)
        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("게시글 공감 삭제 테스트")
    @Transactional
    public void givenPostLikeEntity_whenRemovePostLike_thenPostLikeEntityDeleted() {
        // Given (테스트 데이터 생성)
        PostLikeEntity postLikeEntity = new PostLikeEntity();
        postLikeEntity.setPostNum(1);
        postLikeEntity.setPostWriter("testUser");
        postLikeRepository.save(postLikeEntity);

        // When (테스트할 메서드 실행)
        postLikeService.removePostLike(1);

        // Then (예상 결과 확인)
        assertThatThrownBy(() -> postLikeRepository.findById(1))
                .isInstanceOf(EmptyResultDataAccessException.class);
    }

    @Test
    @DisplayName("존재하지 않는 게시글 공감 삭제 테스트")
    public void givenNonExistingPostLike_whenRemovePostLike_thenExceptionThrown() {
        // When, Then (테스트할 메서드 실행 및 예상 결과 확인)
        assertThatExceptionOfType(EmptyResultDataAccessException.class)
                .isThrownBy(() -> postLikeService.removePostLike(1));
    }
}
