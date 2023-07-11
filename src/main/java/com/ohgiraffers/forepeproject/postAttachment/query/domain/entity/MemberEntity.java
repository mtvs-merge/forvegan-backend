package com.ohgiraffers.forepeproject.postAttachment.query.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {

    private int memberNum;
    private String memberName;
    private String id;
    private int pwd;
    private String nickName;
    private String email;
    private Boolean blacklist;
    private int reportCount;

}
