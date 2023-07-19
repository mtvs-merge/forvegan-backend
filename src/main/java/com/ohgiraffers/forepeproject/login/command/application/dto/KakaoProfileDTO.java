package com.ohgiraffers.forepeproject.login.command.application.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KakaoProfileDTO {

    private long id;
    private String connected_at;
    private KakaoAccount kakao_account;


    @NoArgsConstructor
    @AllArgsConstructor
    @Setter
    @Getter
    @ToString
    public class KakaoAccount {

        private boolean has_email;
        private boolean email_needs_agreement;
        private boolean is_email_valid;
        private boolean is_email_verified;
        private String email;

    }
}


