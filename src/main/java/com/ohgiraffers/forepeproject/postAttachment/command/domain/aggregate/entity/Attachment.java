package com.ohgiraffers.forepeproject.postAttachment.command.domain.aggregate.entity;

import com.ohgiraffers.forepeproject.post.command.domain.aggregate.entity.PostEntity;
import com.ohgiraffers.forepeproject.postAttachment.command.domain.aggregate.vo.AttachmentDate;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Entity(name = "Attachment")
@Table(name = "ATTACHMENT")
public class Attachment {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "ATTACH_NUM",nullable = false)
    private int attachNum;
    @Column(name = "ATTACH_NAME",nullable = false)
    private String attachName;
    @Column(name = "ATTACH_RENAME",nullable = false,length = 40)
    private String attachRename;
    @Column(name = "FILE_TYPE",nullable = false)
    private String fileType;
    @Column(name="SIZE",nullable = false)
    private int size;
    @Embedded
    private AttachmentDate attachmentDate;
    @ManyToOne
    @JoinColumn(name="postNum",nullable = false)
    private PostEntity postNum;

    @Builder
    public Attachment(String attachName,String attachRename,String fileType,int size,AttachmentDate attachmentDate,PostEntity postNum){
        this.attachName=attachName;
        this.attachRename=attachRename;
        this.fileType=fileType;
        this.size=size;
        this.attachmentDate=attachmentDate;
        this.postNum=postNum;
    }
}
