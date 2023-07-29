package com.ohgiraffers.forepeproject.postAttachment.command.domain.repository;


import com.ohgiraffers.forepeproject.postAttachment.command.domain.aggregate.entity.Attachment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AttachmentMapper {
    @PersistenceContext
    private EntityManager manager;

    public void save(Attachment attachment) {
        manager.persist(attachment);
        manager.flush();
    }

    public void del(Long num){
        String jpql = "UPDATE Attachment set deleteYN = 'Y' where postNum = "+num;
        manager.createQuery(jpql).executeUpdate();

    }

    public void modify(Long num){
        String jpql = "delete from Attachment where postNum = "+num;
        manager.createQuery(jpql).executeUpdate();
    }
}
