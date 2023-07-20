package com.ohgiraffers.forepeproject.comment.command.domain.aggregate.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CommentWriter {

    @Column()
    private int commentWriterMemberNo;
}
