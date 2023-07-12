package com.ohgiraffers.forepeproject.postAttachment.command.domain.aggregate.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
@Entity(name = "Attachment")
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
    @Column(name= "ATTACH_POST_NUM")
    private int attachPostNum;
}
