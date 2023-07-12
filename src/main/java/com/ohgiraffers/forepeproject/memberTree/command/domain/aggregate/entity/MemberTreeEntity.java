package com.ohgiraffers.forepeproject.memberTree.command.domain.aggregate.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "MemberTree")
@Table(name = "MEMBER_TREE")
public class MemberTreeEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "TREE_NUM")
    private int treeNum;
    @Column(name = "TREE_NICKNAME")
    private String treeNickName;
    @Column(name = "TREE_MEMBER_NUM")
    private int TreeMemberNum;
    @Column(name = "TREE_EXP")
    private int treeExp;
    @Column(name = "TREE_LEVEL")
    private int treeLevel;
    @Column(name = "TREE_STATE")
    private String treeState;
}
