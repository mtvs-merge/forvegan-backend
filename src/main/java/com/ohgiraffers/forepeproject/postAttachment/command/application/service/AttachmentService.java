package com.ohgiraffers.forepeproject.postAttachment.command.application.service;

import com.ohgiraffers.forepeproject.postAttachment.command.application.dto.AttachmentDTO;
import com.ohgiraffers.forepeproject.postAttachment.command.domain.aggregate.entity.AttachmentMybatis;
import com.ohgiraffers.forepeproject.postAttachment.command.domain.aggregate.entity.AttachmentMybatisResponse;
import com.ohgiraffers.forepeproject.postAttachment.command.domain.repository.AttachmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@org.springframework.stereotype.Service
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
        /* dto -> entity builder */
        List<AttachmentMybatis> uploadFiles = new ArrayList<>();
        for (AttachmentDTO file : files){
            AttachmentMybatis attachment=AttachmentMybatis.builder()
                    .attachName(file.getAttachName())
                    .attachRename(file.getAttachRename())
                    .size(file.getSize())
                    .fileType(file.getFileType())
                    .build();
            attachment.setPostNum(postNum);
            uploadFiles.add(attachment);
        }

        /* save (insert) */
        result = attachmentMapper.insertFiles(uploadFiles);

        return result;
    }

    public List<AttachmentDTO> findAllFileByPostId(long postId){
        List<AttachmentDTO> attachmentDTO = new ArrayList<>();
        List<AttachmentMybatisResponse> files = attachmentMapper.findAllByPostId(postId);
        System.out.println("files = " + files);
        
        System.out.println("주소 서치"+fileUtils.getUploadPath());
        int filesSize=files.size();
        for(int i=0;i<filesSize;i++){
            attachmentDTO.add(i,AttachmentDTO.builder()
                    .attachNum(files.get(i).getAttachNum())
                    .attachName(files.get(i).getAttachName())
                    .attachRename(files.get(i).getAttachRename())
                    .fileType(files.get(i).getFileType())
                    .size(files.get(i).getSize())
                    .build());

        }

        return attachmentDTO;
    }


    @Transactional
    public int deleteAllByPostId(long postNum) {
        int result = 0;
        if(postNum <=0){
            return result;
        }

        result = attachmentMapper.deleteAllByPostId(postNum);

        return result;
    }

    public int modifyAllByPostId(long postNum){
        findAllFileByPostId(postNum);
        int result = 0;
        if(postNum <=0){
            return result;
        }

        result = attachmentMapper.modifyAllByPostId(postNum);

        return result;
    }
}
