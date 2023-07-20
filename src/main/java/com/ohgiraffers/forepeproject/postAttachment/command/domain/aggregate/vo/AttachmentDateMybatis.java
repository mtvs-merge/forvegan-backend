package com.ohgiraffers.forepeproject.postAttachment.command.domain.aggregate.vo;


import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Embeddable;



@NoArgsConstructor
public class AttachmentDateMybatis {
    private char deleteYN;
    private String created_date;
    private String deleted_date;

    @Builder
    public AttachmentDateMybatis(char deleteYN, String created_date, String deleted_date){
        this.deleteYN=deleteYN;
        this.created_date=created_date;
        this.deleted_date=deleted_date;
    }
}
