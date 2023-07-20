package com.ohgiraffers.forepeproject.postAttachment.command.domain.aggregate.vo;


import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
@NoArgsConstructor
public class AttachmentDate {
    @Column(name = "DELETEYN")
    @ColumnDefault("'Y'")
    private char delete_yn;
    @Column(name="CREATED_DATE",nullable = false)
    private String created_date;
    @Column(name="DELETED_DATE",nullable = false)
    private String deleted_date;

    @Builder
    public AttachmentDate(char delete_yn,String created_date,String deleted_date){
        this.delete_yn=delete_yn;
        this.created_date=created_date;
        this.deleted_date=deleted_date;
    }
}
