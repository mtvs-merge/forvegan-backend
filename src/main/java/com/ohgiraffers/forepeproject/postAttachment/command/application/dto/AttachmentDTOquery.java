package com.ohgiraffers.forepeproject.postAttachment.command.application.dto;


import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;



public class AttachmentDTOquery {


    private int attachNum;
    private String attachName;
    private String attachRename;
    private String fileType;
    private long size;
    private long postNum;
    private List<MultipartFile> multipartFile = new ArrayList<>();

    public AttachmentDTOquery() {
    }

    public AttachmentDTOquery(int attachNum, String attachName, String attachRename, String fileType, long size, long postNum, List<MultipartFile> multipartFile) {
        this.attachNum = attachNum;
        this.attachName = attachName;
        this.attachRename = attachRename;
        this.fileType = fileType;
        this.size = size;
        this.postNum = postNum;
        this.multipartFile = multipartFile;
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

    public long getPostNum() {
        return postNum;
    }

    public void setPostNum(long postNum) {
        this.postNum = postNum;
    }

    public List<MultipartFile> getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(List<MultipartFile> multipartFile) {
        this.multipartFile = multipartFile;
    }

}
