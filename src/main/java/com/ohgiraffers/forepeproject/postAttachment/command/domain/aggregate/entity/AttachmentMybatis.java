package com.ohgiraffers.forepeproject.postAttachment.command.domain.aggregate.entity;

import com.ohgiraffers.forepeproject.postAttachment.command.domain.aggregate.vo.AttachmentDate;
import lombok.*;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AttachmentMybatis {

    private int attachNum;
    private String attachName;
    private String attachRename;
    private String fileType;
    private long size;
    private AttachmentDate attachmentMybatis;
    private long postNum;

    @Builder
    public AttachmentMybatis(String attachName,String attachRename,String fileType,long size,AttachmentDate attachmentMybatis){
        this.attachName=attachName;
        this.attachRename=attachRename;
        this.fileType=fileType;
        this.size=size;
        this.attachmentMybatis=attachmentMybatis;
    }

    public void setPostNum(long postNum) {
        this.postNum = postNum;
    }
}
