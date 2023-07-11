package com.ohgiraffers.forepeproject.postAttachment.command.domain.aggregate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Attachment {
    private int attachNum;
    private String attachName;
    private String attachRename;
    private String fileType;
    private int postNum;
}
