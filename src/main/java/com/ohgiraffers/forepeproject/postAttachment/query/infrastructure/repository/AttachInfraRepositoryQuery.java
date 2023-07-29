package com.ohgiraffers.forepeproject.postAttachment.query.infrastructure.repository;



import com.ohgiraffers.forepeproject.postAttachment.query.domain.entity.AttachmentMybatisResponse;
import com.ohgiraffers.forepeproject.postAttachment.query.domain.repository.AttachmentMapperQuery;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public class AttachInfraRepositoryQuery implements AttachmentMapperQuery {
    private SqlSessionTemplate sqlSession;

    @Autowired
    public AttachInfraRepositoryQuery(SqlSessionTemplate sqlSession){
        this.sqlSession=sqlSession;
    }

    @Override
    public List<AttachmentMybatisResponse> findAllByPostId(Long postId) {
        return sqlSession.selectList("AttachmentMapper.findAllByPostId",postId);
    }


}
