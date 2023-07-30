package com.ohgiraffers.forepeproject.post.query.domain.entity;

import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.PostEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    List<PostEntity> getAllPost(int page, int postCategoryNum);

    PostEntity getPostDetails(int postNum);

    int getCountOfPost(int postCategoryNum);
}
