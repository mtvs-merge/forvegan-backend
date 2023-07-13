package com.ohgiraffers.forepeproject.login.command.application.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KakaoProfileDTO {

    private String grantType;
    private long memberId;
    private String accessToken;
    private long accessTokenExpiresIn;

}
