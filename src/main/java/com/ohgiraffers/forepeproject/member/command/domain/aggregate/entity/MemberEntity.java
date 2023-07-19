package com.ohgiraffers.forepeproject.member.command.domain.aggregate.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

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

    @Column(name = "MEMBER_NICKNAME", unique = true)
    private String memberNickName;

    @Column(name = "BLACKLIST")
    private Boolean blacklist;

    @Column(name = "REPORT_COUNT")
    private int reportCount;

    @CreatedDate
    @Column(name = "JOIN_DATE")
    private String joinDate;

    @Column(name = "LEVEL_UP_POINT")
    private int levelUpPoint;

    @Column(name = "SOCIAL_LOGIN")
    private String socialLogin;

    @Column(name = "SOCIAL_ID")
    private long socialId;

    @Column(name = "ACCESS_TOKEN")
    private String accessToken;

    @Column(name = "ACCESS_TOKEN_EXPIRE_DATE")
    private long accessTokenExpireDate;

    @Column(name = "REFRESH_TOKEN")
    private String refreshToken;

    @Column(name = "REFRESH_TOKEN_EXPIRE_DATE")
    private long refreshTokenExpireDate;

    public int getMemberNum() {
        return memberNum;
    }

    @PrePersist
    public void onPrePersist() {
        this.joinDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }


}
