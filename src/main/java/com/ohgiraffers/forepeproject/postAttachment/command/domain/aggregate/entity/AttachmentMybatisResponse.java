package com.ohgiraffers.forepeproject.postAttachment.command.domain.aggregate.entity;

import com.ohgiraffers.forepeproject.postAttachment.command.domain.aggregate.vo.AttachmentDate;
import lombok.Builder;
import lombok.Getter;

public class AttachmentMybatisResponse {

    private int attachNum;
    private String attachName;
    private String attachRename;
    private String fileType;
    private long size;
    private AttachmentDate attachmentDate;
    private long postNum;

    public AttachmentMybatisResponse() {
    }

    public AttachmentMybatisResponse(int attachNum, String attachName, String attachRename, String fileType, long size, AttachmentDate attachmentDate, long postNum) {
        this.attachNum = attachNum;
        this.attachName = attachName;
        this.attachRename = attachRename;
        this.fileType = fileType;
        this.size = size;
        this.attachmentDate = attachmentDate;
        this.postNum = postNum;
    }

    public int getAttachNum() {
        return attachNum;
    }

    public void setAttachNum(int attachNum) {
        this.attachNum = attachNum;
    }

    public String getAttachName() {
        return attachName;
    }

    public void setAttachName(String attachName) {
        this.attachName = attachName;
    }

    public String getAttachRename() {
        return attachRename;
    }

    public void setAttachRename(String attachRename) {
        this.attachRename = attachRename;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public AttachmentDate getAttachmentDate() {
        return attachmentDate;
    }

    public void setAttachmentDate(AttachmentDate attachmentDate) {
        this.attachmentDate = attachmentDate;
    }

    public long getPostNum() {
        return postNum;
    }

    public void setPostNum(long postNum) {
        this.postNum = postNum;
    }

    @Override
    public String toString() {
        return "AttachmentMybatisResponse{" +
                "attachNum=" + attachNum +
                ", attachName='" + attachName + '\'' +
                ", attachRename='" + attachRename + '\'' +
                ", fileType='" + fileType + '\'' +
                ", size=" + size +
                ", attachmentDate=" + attachmentDate +
                ", postNum=" + postNum +
                '}';
    }
}
