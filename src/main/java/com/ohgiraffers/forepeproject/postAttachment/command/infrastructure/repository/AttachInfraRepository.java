package com.ohgiraffers.forepeproject.postAttachment.command.infrastructure.repository;


import com.ohgiraffers.forepeproject.postAttachment.command.domain.aggregate.entity.AttachmentMybatis;
import com.ohgiraffers.forepeproject.postAttachment.command.domain.aggregate.entity.AttachmentMybatisResponse;
import com.ohgiraffers.forepeproject.postAttachment.command.domain.repository.AttachmentMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public class AttachInfraRepository implements AttachmentMapper {
    private SqlSessionTemplate sqlSession;

    @Autowired
    public AttachInfraRepository(SqlSessionTemplate sqlSession){
        this.sqlSession=sqlSession;
    }
    @Override
    public int insertFiles(List<AttachmentMybatis> files) {
        return sqlSession.insert("AttachmentMapper.insertFiles",files);
    }

    @Override
    public List<AttachmentMybatisResponse> findAllByPostId(Long postId) {
        return sqlSession.selectList("AttachmentMapper.findAllByPostId",postId);
    }

    @Override
    public int deleteAllByPostId(Long postNum) {
        return sqlSession.update("AttachmentMapper.deleteAllByPostId",postNum);
    }

    @Override
    public int modifyAllByPostId(Long postNum) {
        return sqlSession.delete("AttachmentMapper.modifyAllByPostId",postNum);
    }
}
