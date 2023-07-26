package com.ohgiraffers.forepeproject.member.command.domain.aggregate.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity(name = "Member")
@Table(name = "MEMBER")
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "SEQ_MEMBER_NUM",
        initialValue = 1,
        allocationSize = 50
)
public class MemberEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_SEQ_GENERATOR"
    )
    @Column(name = "MEMBER_NUM")
    private int memberNum;

    @Column(name = "MEMBER_NAME", nullable = false)
    private String memberName;

    @Column(name = "MEMBER_NICKNAME", unique = true, nullable = false)
    private String memberNickname;

    @Column(name = "BLACKLIST", nullable = false)
    private Boolean blacklist;

    @Column(name = "REPORT_COUNT", nullable = false)
    private int reportCount;

    @CreatedDate
    @Column(name = "JOIN_DATE", nullable = false)
    private String joinDate;

    @Column(name = "LEVEL_UP_POINT", nullable = false)
    private int levelUpPoint;

    @Column(name = "SOCIAL_LOGIN", nullable = false)
    private String socialLogin;

    @Column(name = "SOCIAL_ID", nullable = false)
    private String socialId;

    @Column(name = "ACCESS_TOKEN", nullable = false)
    private String accessToken;

    @Column(name = "ACCESS_TOKEN_EXPIRE_DATE", nullable = false)
    private long accessTokenExpireDate;

    @Column(name = "REFRESH_TOKEN", nullable = false)
    private String refreshToken;

    @Column(name = "REFRESH_TOKEN_EXPIRE_DATE", nullable = false)
    private long refreshTokenExpireDate;

    @Column(name = "PREFERRED_LOCATION")
    private String preferredLocation;

    @Column(name = "PREFERRED_TYPE")
    private String preferredType;

    @Column(name = "IS_DELETED", columnDefinition = "varchar (2)", nullable = false)
    private String isDeleted;

    public MemberEntity() {}

    public int getMemberNum() {
        return memberNum;
    }

    @PrePersist
    public void onPrePersist() {
        this.joinDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }


    public void setPreferredLocation(String preferredLocation) {
        this.preferredLocation = preferredLocation;
    }

    public void setPreferredType(String preferredType) {
        this.preferredType = preferredType;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }
}
