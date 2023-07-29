package com.ohgiraffers.forepeproject.like.command.domain.repository;

import com.ohgiraffers.forepeproject.like.command.domain.aggregate.entity.CommentLikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentLikeRepository extends JpaRepository<CommentLikeEntity, Integer> {
}
