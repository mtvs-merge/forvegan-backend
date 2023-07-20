package com.ohgiraffers.forepeproject.post.command.domain.repository;

import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.PostEntity;
import com.ohgiraffers.forepeproject.post.command.domain.aggregate.vo.PostVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
