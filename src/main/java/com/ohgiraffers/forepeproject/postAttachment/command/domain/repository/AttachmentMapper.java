package com.ohgiraffers.forepeproject.postAttachment.command.domain.repository;


import com.ohgiraffers.forepeproject.postAttachment.command.domain.aggregate.entity.Attachment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AttachmentMapper {
    void insertFiles(List<Attachment> files);

    void deleteAllByPostId(Long postNum);

    void modifyAllByPostId(Long postNum);
}
