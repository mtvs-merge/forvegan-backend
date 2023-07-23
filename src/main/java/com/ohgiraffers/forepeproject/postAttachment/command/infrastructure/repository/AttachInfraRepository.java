package com.ohgiraffers.forepeproject.postAttachment.command.infrastructure.repository;


import com.ohgiraffers.forepeproject.postAttachment.command.domain.aggregate.entity.Attachment;
import com.ohgiraffers.forepeproject.postAttachment.command.domain.repository.AttachmentMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AttachInfraRepository implements AttachmentMapper {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void insertFiles(List<Attachment> files) {
         manager.persist(files);
         manager.flush();
    }

    @Override
    public void deleteAllByPostId(Long postNum) {
        Attachment attachments = manager.find(Attachment.class,postNum);
        attachments.setDeleteYN("Y");
        manager.flush();
    }

    @Override
    public void modifyAllByPostId(Long postNum) {
        Attachment attachments = manager.find(Attachment.class,postNum);
        manager.remove(attachments);
        manager.flush();
    }
}
