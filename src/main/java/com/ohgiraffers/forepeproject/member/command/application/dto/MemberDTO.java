package com.ohgiraffers.forepeproject.member.command.application.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDTO {
    private long MemberNum;
    private String MemberName;
    private String socialLogin;
    private long socialId;
    private String email;
    private String accessToken;
    private long accessTokenExpireDate;
    private String refreshToken;
    private long refreshTokenExpireDate;
    private LocalDateTime signUpDate;
    private String MemberId;
    private String MemberPwd;
    private String MemberNickname;
    private String blacklist;
    private int reportCount;
    private String joinDate;
    private int LevelUpPoint;
    private String lastAccessDate;
}
