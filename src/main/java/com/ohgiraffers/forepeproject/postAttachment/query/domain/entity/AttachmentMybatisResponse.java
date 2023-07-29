package com.ohgiraffers.forepeproject.postAttachment.query.domain.entity;



public class AttachmentMybatisResponse {

    private int attachNum;
    private String attachName;
    private String attachRename;
    private String fileType;
    private long size;
    private String deleteYN;
    private long postNum;

    public AttachmentMybatisResponse() {
    }

    public AttachmentMybatisResponse(String attachName, String attachRename, String fileType, long size, String deleteYN, long postNum) {
        this.attachName = attachName;
        this.attachRename = attachRename;
        this.fileType = fileType;
        this.size = size;
        this.deleteYN = deleteYN;
        this.postNum = postNum;
    }

    public int getAttachNum() {
        return attachNum;
    }

    public String getAttachName() {
        return attachName;
    }

    public String getAttachRename() {
        return attachRename;
    }

    public String getFileType() {
        return fileType;
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

    @Override
    public String toString() {
        return "AttachmentMybatisResponse{" +
                "attachNum=" + attachNum +
                ", attachName='" + attachName + '\'' +
                ", attachRename='" + attachRename + '\'' +
                ", fileType='" + fileType + '\'' +
                ", size=" + size +
                ", deleteYN='" + deleteYN + '\'' +
                ", postNum=" + postNum +
                '}';
    }
}
