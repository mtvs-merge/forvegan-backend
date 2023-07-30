package com.ohgiraffers.forepeproject.postAttachment.command.domain.aggregate.entity;

import com.ohgiraffers.forepeproject.postAttachment.command.domain.aggregate.vo.FileSize;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "ATTACHMENT")
public class Attachment {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "ATTACH_NUM")
    private int attachNum;

    @Column(name = "ATTACH_NAME")
    private String attachName;

    @Column(name = "ATTACH_RENAME")
    private String attachRename;

    @Column(name = "FILE_TYPE")
    private String fileType;

    @Column(name = "DELETE_YN" ,columnDefinition = "CHAR(1) default 'N'")
    private String deleteYN;

    @Column(name = "POST_NUM",length = 40)
    private long postNum;

    @Embedded
    private FileSize fileSize;


    public Attachment(String attachName, String attachRename, String fileType, FileSize fileSize) {
        this.attachName = attachName;
        this.attachRename = attachRename;
        this.fileType = fileType;
        this.fileSize = fileSize;
    }

    public Attachment(String attachName, String attachRename, String fileType, String deleteYN, FileSize fileSize) {
        this.attachName = attachName;
        this.attachRename = attachRename;
        this.fileType = fileType;
        this.deleteYN = deleteYN;
        this.fileSize = fileSize;
    }

    public Attachment(String attachName, String attachRename, String fileType, String deleteYN, Long postNum, FileSize fileSize) {
        this.attachName = attachName;
        this.attachRename = attachRename;
        this.fileType = fileType;
        this.deleteYN = deleteYN;
        this.postNum = postNum;
        this.fileSize = fileSize;
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

    public String getDeleteYN() {
        return deleteYN;
    }

    public Long getPostNum() {
        return postNum;
    }

    public FileSize getSize() {
        return fileSize;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "attachNum=" + attachNum +
                ", attachName='" + attachName + '\'' +
                ", attachRename='" + attachRename + '\'' +
                ", fileType='" + fileType + '\'' +
                ", deleteYN='" + deleteYN + '\'' +
                ", postNum=" + postNum +
                ", size=" + fileSize +
                '}';
    }
}
