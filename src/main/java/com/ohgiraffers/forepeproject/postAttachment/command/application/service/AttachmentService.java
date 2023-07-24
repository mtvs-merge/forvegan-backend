package com.ohgiraffers.forepeproject.postAttachment.command.application.service;

import com.ohgiraffers.forepeproject.postAttachment.command.application.dto.AttachmentDTO;
import com.ohgiraffers.forepeproject.postAttachment.command.domain.aggregate.entity.Attachment;
import com.ohgiraffers.forepeproject.postAttachment.command.domain.aggregate.vo.FileSize;
import com.ohgiraffers.forepeproject.postAttachment.command.domain.repository.AttachmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


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
//         dto -> entity builder
        List<Attachment> uploadFiles = new ArrayList<>();
        for (AttachmentDTO file : files){
            Attachment attachment=new Attachment(
                    file.getAttachName(),
                    file.getAttachRename(),
                    file.getFileType(),
                    new FileSize(file.getSize())
            );
            attachment.setPostNum(postNum);
            uploadFiles.add(attachment);
        }

//      save (insert)
        attachmentMapper.insertFiles(uploadFiles);

        return result;
    }



    @Transactional
    public int deleteAllByPostId(long postNum) {
        int result = 0;
        if(postNum <=0){
            return result;
        }

       attachmentMapper.deleteAllByPostId(postNum);

        return result;
    }

    public int modifyAllByPostId(long postNum,List<AttachmentDTO> files){
        int result = 0;
        if(postNum <=0){
            return result;
        }

        attachmentMapper.modifyAllByPostId(postNum);
        addAttachment(postNum,files);
        return result;
    }
}
