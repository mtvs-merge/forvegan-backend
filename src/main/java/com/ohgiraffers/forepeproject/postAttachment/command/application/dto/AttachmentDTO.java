package com.ohgiraffers.forepeproject.postAttachment.command.application.dto;



import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;


@Getter
public class AttachmentDTO {


    private int attachNum;
    private String attachName;
    private String attachRename;
    private String fileType;
    private long size;
    private long postNum;
    private List<MultipartFile> multipartFile = new ArrayList<>();

    @Builder
    public AttachmentDTO(int attachNum,String attachName,String attachRename,String fileType,long size){
        this.attachNum=attachNum;
        this.attachName=attachName;
        this.attachRename=attachRename;
        this.fileType=fileType;
        this.size=size;
    }


    public void setPostNum(long postNum) {
        this.postNum = postNum;
    }
}
