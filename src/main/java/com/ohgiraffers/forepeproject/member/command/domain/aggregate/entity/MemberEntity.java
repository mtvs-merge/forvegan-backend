package com.ohgiraffers.forepeproject.member.command.domain.aggregate.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Member")
@Table(name = "MEMBER")
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "SEQ_MEMBER_NUM",
        initialValue = 1,
        allocationSize = 1
)
public class MemberEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_SEQ_GENERATOR"
    )
    @Column(name = "MEMBER_NUM")
    private int memberNum;

    @Column(name = "MEMBER_NAME")
    private String memberName;

    @Column(name = "MEMBER_ID")
    private String memberId;

    @Column(name = "MEMBER_PWD")
    private int memberPwd;

    @Column(name = "MEMBER_NICKNAME")
    private String memberNickName;

    @Column(name = "BLACKLIST")
    private Boolean blacklist;

    @Column(name = "REPORT_COUNT")
    private int reportCount;

    @Column(name = "JOIN_DATE")
    private String joinDate;

    @Column(name = "LEVEL_UP_POINT")
    private int levelUpPoint;

    @PrePersist
    public void onPrePersist() {
        this.joinDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }


}
