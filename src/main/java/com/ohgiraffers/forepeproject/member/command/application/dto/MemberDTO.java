package com.ohgiraffers.forepeproject.member.command.application.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDTO {
    private int MemberNum;
    private String MemberName;
    private String MemberId;
    private String MemberPwd;
    private String MemberNickname;
    private String blacklist;
    private int reportCount;
    private String joinDate;
    private int LevelUpPoint;
}
