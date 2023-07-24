package com.ohgiraffers.forepeproject.comment.command.application.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class commentDTO {

    private int commentNum;
    private String commentWriter;
    private String comments;
    private String commentDate;
    private int commentLike;
}
