package com.ohgiraffers.forepeproject.comment.command.domain.aggregate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentEntity {
    private int commentNum;
    private String commentDetail;
    private String commentDate;
    private String commentWriter;
    private int commentPostNum;
    private int commentLike;
}
