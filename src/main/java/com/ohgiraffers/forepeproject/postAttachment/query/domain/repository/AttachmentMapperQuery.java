package com.ohgiraffers.forepeproject.postAttachment.query.domain.repository;



import com.ohgiraffers.forepeproject.postAttachment.query.domain.entity.AttachmentMybatisResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttachmentMapperQuery {

    List<AttachmentMybatisResponse> findAllByPostId(Long postId);

}
