package com.ohgiraffers.forepeproject.comment.command.application.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {

    private int commentNum;
    private String commentWriter;
    private String comments;
    private String commentDate;
    private int commentLike;

    public static String Getcomments() {
        return null;
    }

    public String getComments() {
        return null;
    }
}
