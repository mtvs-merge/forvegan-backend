package com.ohgiraffers.forepeproject.memberTree.command.domain.aggregate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberTreeEntity {

    private int treeNum;
    private String treeNickName;
    private int memberNum;
    private int treeExp;
    private int treeLevel;
    private String treeState;
}
