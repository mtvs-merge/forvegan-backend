package com.ohgiraffers.forepeproject.post.command.domain.repository;

import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<PostEntity, Integer> {

    PostEntity findByPostNum(int postNum);

}
