package com.ohgiraffers.forepeproject.postAttachment.command.infrastructure.repository;


import com.ohgiraffers.forepeproject.postAttachment.command.domain.aggregate.entity.Attachment;
import com.ohgiraffers.forepeproject.postAttachment.command.domain.repository.AttachmentMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AttachInfraRepository{
    @PersistenceContext
    private EntityManager manager;
    private AttachmentMapper mapper;

    @Autowired
    public AttachInfraRepository(AttachmentMapper mapper){
        this.mapper = mapper;
    }

    public void insertFiles(List<Attachment> files) {
         manager.persist(files);
         manager.flush();
    }

    public void deleteAllByPostId(Long postNum) {
        Attachment attachments = manager.find(Attachment.class,postNum);
        attachments.setDeleteYN("Y");
        manager.flush();
    }

    public void modifyAllByPostId(Long postNum) {
        Attachment attachments = manager.find(Attachment.class,postNum);
        manager.remove(attachments);
        manager.flush();
    }

}
