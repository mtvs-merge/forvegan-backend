package com.ohgiraffers.forepeproject.post.command.domain.repository;

import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.PostEntity;
import com.ohgiraffers.forepeproject.post.command.domain.aggregate.vo.PostVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer> {

    PostEntity findByPostNum(int postNum);

}
