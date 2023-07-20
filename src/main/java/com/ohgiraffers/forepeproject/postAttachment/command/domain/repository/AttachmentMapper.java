package com.ohgiraffers.forepeproject.postAttachment.command.domain.repository;


import com.ohgiraffers.forepeproject.postAttachment.command.domain.aggregate.entity.AttachmentMybatis;
import com.ohgiraffers.forepeproject.postAttachment.command.domain.aggregate.entity.AttachmentMybatisResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AttachmentMapper {
    int insertFiles(List<AttachmentMybatis> files);

    List<AttachmentMybatisResponse> findAllByPostId(Long postId);

    int deleteAllByPostId(Long postNum);

    int modifyAllByPostId(Long postNum);
}
