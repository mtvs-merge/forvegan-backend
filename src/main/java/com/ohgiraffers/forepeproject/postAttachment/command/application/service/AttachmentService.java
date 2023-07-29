package com.ohgiraffers.forepeproject.postAttachment.command.application.service;

import com.ohgiraffers.forepeproject.postAttachment.command.application.dto.AttachmentDTO;
import com.ohgiraffers.forepeproject.postAttachment.command.domain.aggregate.entity.Attachment;
import com.ohgiraffers.forepeproject.postAttachment.command.domain.aggregate.vo.FileSize;
import com.ohgiraffers.forepeproject.postAttachment.command.domain.repository.AttachmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class AttachmentService {
    AttachmentMapper attachmentMapper;
    FileUtils fileUtils;


    @Autowired
    public AttachmentService(AttachmentMapper attachmentMapper,FileUtils fileUtils){
        this.attachmentMapper=attachmentMapper;
        this.fileUtils=fileUtils;
    }
    @Transactional
    public int addAttachment(long postNum, List<AttachmentDTO> files) {
        int result = 0;
        if(CollectionUtils.isEmpty(files)){
            return result;
        }

        for (AttachmentDTO file : files){
            Attachment attachment=new Attachment(
                    file.getAttachName(),
                    file.getAttachRename(),
                    file.getFileType(),
                    new FileSize(file.getSize())
            );
            attachment.setDeleteYN("N");
            attachment.setPostNum(postNum);
            attachmentMapper.save(attachment);
        }
        result =1;

        return result;
    }



    @Transactional
    public int deleteAllByPostId(long postNum) {
        int result = 0;
        if(postNum <=0){
            return result;
        }
        attachmentMapper.del(postNum);
//       attachmentMapper.deleteAllByPostId(postNum);

        return result;
    }
    @Transactional
    public int modifyAllByPostId(long postNum,List<AttachmentDTO> files){
        int result = 0;
        if(postNum <=0){
            return result;
        }
        attachmentMapper.modify(postNum);
//        attachmentMapper.modifyAllByPostId(postNum);
        addAttachment(postNum,files);
        return result;
    }
}
