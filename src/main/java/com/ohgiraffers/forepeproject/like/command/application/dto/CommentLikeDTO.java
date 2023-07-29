package com.ohgiraffers.forepeproject.like.command.application.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommentLikeDTO {

    private int commentNum;
    private int commentLikeNum;
    private String commentWriter;
    private String commentLikeUser;

}
