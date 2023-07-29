package com.ohgiraffers.forepeproject.postAttachment.query.application.service;


import com.ohgiraffers.forepeproject.postAttachment.query.application.dto.AttachmentDTOQuery;
import com.ohgiraffers.forepeproject.postAttachment.query.domain.entity.AttachmentMybatisResponse;
import com.ohgiraffers.forepeproject.postAttachment.query.domain.repository.AttachmentMapperQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttachmentServiceQuery {
    AttachmentMapperQuery attachmentMapperQuery;
    FileUtilsQuery fileUtilsQuery;

    @Autowired
    public AttachmentServiceQuery(AttachmentMapperQuery attachmentMapperQuery, FileUtilsQuery fileUtilsQuery){
        this.attachmentMapperQuery = attachmentMapperQuery;
        this.fileUtilsQuery = fileUtilsQuery;
    }
    public List<AttachmentDTOQuery> findAllFileByPostId(long postId){
        List<AttachmentDTOQuery> attachmentDTO = new ArrayList<>();
        List<AttachmentMybatisResponse> files = attachmentMapperQuery.findAllByPostId(postId);
        System.out.println("files = " + files);
        
        System.out.println("주소 서치"+ fileUtilsQuery.getUploadPath());
        int filesSize=files.size();
        for(AttachmentMybatisResponse file: files){
            attachmentDTO.add(new AttachmentDTOQuery(
                    file.getAttachNum(),
                    file.getAttachName(),
                    file.getAttachRename(),
                    file.getFileType(),
                    file.getSize(),
                    file.getPostNum()
            ));
        }

        return attachmentDTO;
    }
}
